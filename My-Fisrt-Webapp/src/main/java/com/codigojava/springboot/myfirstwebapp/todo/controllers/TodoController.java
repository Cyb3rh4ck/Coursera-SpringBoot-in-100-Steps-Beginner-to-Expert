package com.codigojava.springboot.myfirstwebapp.todo.controllers;


import java.time.LocalDate;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codigojava.springboot.myfirstwebapp.todo.models.Todo;
import com.codigojava.springboot.myfirstwebapp.todo.services.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = (String)model.getAttribute("username");
		model.addAttribute("todos",todoService.findByUsername(username));
		return "listTodos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.getAttribute("username");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(model.getAttribute("name").toString(), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute(todo);
		return "todo";
	}
	
	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUsername((String)todo.getUsername());
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

}
