package com.codigojava.springboot.learn_spring_boot.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codigojava.springboot.learn_spring_boot.models.Course;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "CodigoJava"), 
				new Course(2, "Learn DevOps", "CodigoJava"),
				new Course(3, "Learn Azure", "CodigoJava"), 
				new Course(4, "GCP", "CodigoJava"));
	}

}
