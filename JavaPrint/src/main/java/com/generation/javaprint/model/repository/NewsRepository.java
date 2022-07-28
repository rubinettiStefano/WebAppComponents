package com.generation.javaprint.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.javaprint.model.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>
{

}
