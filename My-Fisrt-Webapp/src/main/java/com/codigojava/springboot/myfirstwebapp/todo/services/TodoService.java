package com.codigojava.springboot.myfirstwebapp.todo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codigojava.springboot.myfirstwebapp.todo.models.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "CodigoJava", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "CodigoJava", "Learn DevOps", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "CodigoJava", "Learn Full Statck Development", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

}
