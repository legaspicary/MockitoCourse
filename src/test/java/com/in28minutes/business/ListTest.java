package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void mockMultipleValues() {
		// Given
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		// When
		
		// Then
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void mockGet() {
		List listMock = mock(List.class);
		// Argument matchers -> anyInt, anyString
		when(listMock.get(anyInt())).thenReturn("Cary cary");
		assertEquals("Cary cary", listMock.get(0));
		assertEquals("Cary cary", listMock.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void mockException() {
		List listMock = mock(List.class);
		// Argument matchers -> anyInt, anyString
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Error occured"));
		listMock.get(0);
	}
}
