package com.in28minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import com.in28minutes.data.business.TodoBusinessImpl;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpringStub1() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
		List<String> filtered = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filtered.size());
	}

}
