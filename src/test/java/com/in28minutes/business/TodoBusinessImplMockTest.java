package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
	
	//BDD approach
	@Test
	public void testRetrieveTodosRelatedToSpringMock3() {
		//given
		TodoService todoServiceMock = mock(TodoService.class);
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(Arrays.asList());
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
		//when
		List<String> filtered = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
		//then
		assertThat(filtered.size(), is(0));
	}
	
	//Verify calls when there are side effects
	@Test
	public void testRetrieveTodosRelatedToSpringMock4() {
		//given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
		//when
		todoBusiness.deleteTodosNotRelatedToSpring("Dummy");
		//then
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
//		verify(todoServiceMock, times(1)).deleteTodo("Learn Spring MVC");
		//could also use atleast
	}
	
		//using then
		@Test
		public void testRetrieveTodosRelatedToSpringMock5() {
			//given
			TodoService todoServiceMock = mock(TodoService.class);
			List<String> allTodos = Arrays.asList("Learn Spring MVC",
					"Learn Spring", "Learn to Dance");
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
			TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
			//when
			todoBusiness.deleteTodosNotRelatedToSpring("Dummy");
			//then
			then(todoServiceMock).should().deleteTodo("Learn to Dance");
			then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
//			verify(todoServiceMock, times(1)).deleteTodo("Learn Spring MVC");
			//could also use at least
		}
		
		//arg capture
		@Test
		public void testRetrieveTodosRelatedToSpringMock6() {
			//given
			ArgumentCaptor<String> strinArgumentCaptor = ArgumentCaptor.forClass(String.class);
			TodoService todoServiceMock = mock(TodoService.class);
			List<String> allTodos = Arrays.asList("Learn Rock n Roll",
					"Learn Spring", "Learn to Dance");
			given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
			TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
			//when
			todoBusiness.deleteTodosNotRelatedToSpring("Dummy");
			//then
			then(todoServiceMock).should(times(2)).deleteTodo(strinArgumentCaptor.capture());
			//could also use at least
			assertThat(strinArgumentCaptor.getAllValues().size(), is(2));
		}

}
