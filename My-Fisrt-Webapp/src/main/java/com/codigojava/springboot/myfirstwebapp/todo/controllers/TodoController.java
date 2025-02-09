package com.codigojava.springboot.myfirstwebapp.todo.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codigojava.springboot.myfirstwebapp.todo.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(Model model) {
		model.addAttribute("todos",todoService.findByUsername("CodigoJava"));
		return "listTodos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage() {
		return "todo";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(@RequestParam String description, Model model) {
		todoService.addTodo(model.getAttribute("name").toString(), description, LocalDate.now().plusMonths(8), false);
		return "redirect:list-todos";
	}


}
