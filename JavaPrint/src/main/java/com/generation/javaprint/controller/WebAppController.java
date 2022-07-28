package com.generation.javaprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller per produrre la nostra SPA - Single Page Application

@Controller
public class WebAppController
{

	@RequestMapping("/news/main")
	public String mainPage()
	{
		return "Main";
	}
	
}
