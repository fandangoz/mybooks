package com.mybooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Purpose of this controller is to map application root url into welcome page
 * On browser {host}/mybooks/ page booksList.jsp will be provided
 * In this version application is single paged so it should me only mapped page in application
 */
@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("booksList");
	
		return model;

	}

}