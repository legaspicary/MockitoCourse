package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.business.TodoBusinessImpl;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpringMock1() {
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fly"));
		
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
		List<String> filtered = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filtered.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpringMock2() {
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList());
		
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
		List<String> filtered = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filtered.size());
	}

}
