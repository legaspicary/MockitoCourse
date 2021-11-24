package com.in28minutes.data.business;

import java.util.List;
import java.util.stream.Collectors;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> todos = todoService.retrieveTodos(user);
		List<String> filteredTodos = todos.stream().filter(str -> str.contains("Spring")).collect(Collectors.toList());
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
