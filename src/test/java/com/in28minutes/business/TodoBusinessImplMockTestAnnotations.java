package com.in28minutes.business;

//import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
//import org.mockito.Mockito.stub;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.business.TodoBusinessImpl;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTestAnnotations {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> strinArgumentCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpringMock2() {
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Fly"));
		List<String> filtered = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filtered.size());
	}
	
	//arg capture
	@Test
	public void testRetrieveTodosRelatedToSpringMock6() {
		//given
		List<String> allTodos = Arrays.asList("Learn Rock n Roll",
				"Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allTodos);
		//when
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		//then
		then(todoServiceMock).should(times(2)).deleteTodo(strinArgumentCaptor.capture());
		//could also use at least
		assertThat(strinArgumentCaptor.getAllValues().size(), is(2));
	}
	
	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		verify(listSpy).add("Ranga");
		verify(listSpy).add("in28Minutes");

		assertEquals(2, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}

//	@Test
//	public void creatingASpyOnArrayList_overridingSpecificMethods() {
//		List<String> listSpy = spy(ArrayList.class);
//		listSpy.add("Ranga");
//		listSpy.add("in28Minutes");
//
//		stub(listSpy.size()).toReturn(-1);
//
//		assertEquals(-1, listSpy.size());
//		assertEquals("Ranga", listSpy.get(0));
//
//		// @Spy Annotation
//	}

}
