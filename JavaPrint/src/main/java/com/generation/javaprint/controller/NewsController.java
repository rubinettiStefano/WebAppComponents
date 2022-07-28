package com.generation.javaprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javaprint.model.repository.NewsRepository;

@RestController
public class NewsController
{
	//Voglio getAll, con tutte, e getLatest, con le ultime 20
	@Autowired
	NewsRepository newsRepository;
	
	@GetMapping("/news")
	public ResponseEntity<Object> getAll()
	{
		try
		{
			return ResponseEntity.ok(newsRepository.findAll());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("");
		}
	}
}
