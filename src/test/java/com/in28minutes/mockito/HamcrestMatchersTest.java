package com.in28minutes.mockito;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Number> scores = Arrays.asList(99,199,101.015);
		assertThat(scores, hasSize(4));
		// other parameters for assertThat
		//hasItems
		//everyItem(greaterThan)
		//isEmptyOrNullString
		//arrayContaining(1,2,3)
		//arrayWithSize
		//ArrayContainingInAnyOrder
	}

}
