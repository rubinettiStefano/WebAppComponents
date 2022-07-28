package com.generation.javaprint.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.javaprint.model.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>
{

}
