package com.codigojava.springboot.myfirstwebapp.todo.controllers;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codigojava.springboot.myfirstwebapp.todo.models.Todo;
import com.codigojava.springboot.myfirstwebapp.todo.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		model.addAttribute("todos",todoService.findByUsername("CodigoJava"));
		return "listTodos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.getAttribute("username");
		Todo todo = new Todo(0, username, "Defatul Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, Todo todo) {
		todoService.addTodo(model.getAttribute("name").toString(), todo.getDescription(), LocalDate.now().plusMonths(8), false);
		return "redirect:list-todos";
	}


}
