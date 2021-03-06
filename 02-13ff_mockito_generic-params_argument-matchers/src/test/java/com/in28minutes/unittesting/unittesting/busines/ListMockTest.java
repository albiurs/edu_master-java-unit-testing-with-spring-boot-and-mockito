package com.in28minutes.unittesting.unittesting.busines;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ListMockTest
 *
 * @author created by Urs Albisser, on 2020-01-05
 * @version 0.0.1
 */
public class ListMockTest {


	// == fields ==
	List listMock = mock(List.class); // Mockito.mock > create a mock for the java.util.List interface


	// == Tests ==

	/**
	 * size_basic()
	 * Basic JUnit test with one mock value to be tested.
	 */
	@Test
	public void size_basic() {

		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(listMock.size()).thenReturn(5);

		assertEquals(5,listMock.size());
	}

	/**
	 * returnDifferenValues()
	 * JUnit test with multiple mock values to be tested.
	 */
	@Test
	public void returnDifferenValues() {

		// when "mock.size()" is called 1st time, thenReturn(xxx)
		// when "mock.size()" is called 2nd time, thenReturn(yyy)
		when(listMock.size()).thenReturn(5).thenReturn(10);

		assertEquals(5,listMock.size());
		assertEquals(10,listMock.size());
	}

	/**
	 * returnWithParameters()
	 * JUnit test with parametrized values to be tested.
	 */
	@Test
	public void returnWithParameters() {

		// when(myServiceMock.classToBeCalled(parameterToBeTested)) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(listMock.get(0)).thenReturn("got mock.get(0)");

		assertEquals("got mock.get(0)", listMock.get(0)); // test with a mocked parameter 0
		assertEquals(null, listMock.get(1)); // test with a mocked parameter 1 -> returns null because 1 is not defined above.
	}

	/**
	 * returnWithGenericParameters()
	 * JUnit test with generic parametrized values to be tested.
	 */
	@Test
	public void returnWithGenericParameters() {

		// when(myServiceMock.classToBeCalled(parameterToBeTested)) is called, thenReturn(mockParameterToBeTestedAgainst)
		// org.mockito.ArgumentMatchers.anyInt(): check any matching parameter using the mockito argument matcher method.
		// org.mockito.ArgumentMatchers.anyInt(): checkout other argument matchers like:
		// anyDouble(), anyBoolean(), anyCollection(), anyList(), anyMap()...
		when(listMock.get(anyInt())).thenReturn("got mock.get(0)");

		assertEquals("got mock.get(0)", listMock.get(0)); // test with a mocked parameter 0
		assertEquals("got mock.get(0)", listMock.get(1)); // test with a mocked parameter 1 -> returns null because 1 is not defined above.
	}
}
