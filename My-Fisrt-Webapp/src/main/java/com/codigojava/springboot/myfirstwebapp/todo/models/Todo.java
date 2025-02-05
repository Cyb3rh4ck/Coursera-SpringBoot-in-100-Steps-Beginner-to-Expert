package com.codigojava.springboot.myfirstwebapp.todo.models;

import java.time.LocalDate;

public class Todo {
	
	private int id;
	private String username;
	private String descriptiion;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String username, String descriptiion, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.descriptiion = descriptiion;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescriptiion() {
		return descriptiion;
	}

	public void setDescriptiion(String descriptiion) {
		this.descriptiion = descriptiion;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", descriptiion=" + descriptiion + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	

}
