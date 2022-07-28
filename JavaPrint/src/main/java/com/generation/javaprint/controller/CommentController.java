package com.generation.javaprint.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javaprint.model.entities.Comment;
import com.generation.javaprint.model.entities.News;
import com.generation.javaprint.model.entities.NewsFactory;
import com.generation.javaprint.model.repository.CommentRepository;
import com.generation.javaprint.model.repository.NewsRepository;
@RestController
public class CommentController
{
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	NewsRepository newsRepository;
	
	@GetMapping("/comments")
	public ResponseEntity<Object> getAll()
	{
		try
		{
			return ResponseEntity.ok(commentRepository.findAll());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("");
		}
	}
	
	@PostMapping("/news/{newsid}/comments")
	public ResponseEntity<Object> insert(@PathVariable int newsid,@RequestBody Comment comment)
	{
		Optional<News> linkedNews = newsRepository.findById(newsid);
		
		if(linkedNews.isPresent())
		{
			comment.setDatetime(NewsFactory.getNow());
			linkedNews.get().addComment(comment);
			commentRepository.save(comment);
			return ResponseEntity.ok(comment);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}
	}
}
