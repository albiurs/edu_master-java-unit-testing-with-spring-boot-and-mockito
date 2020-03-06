package com.in28minutes.unittesting.unittesting.busines;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * ListMockTest
 *
 * @author created by Urs Albisser, on 2020-01-05
 * @version 0.0.1
 */
public class ListMockTest {


	// == fields ==
//	List listMock = mock(List.class); // Mockito.mock > create a mock for the java.util.List interface
	List<String> listMock = mock(List.class); // Mockito.mock > create a mock for the java.util.List <String> interface


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

	/**
	 * verificationBasics()
	 * Verification tests: Important if values are not returned back, so they cannot be tested.
	 * Test if the specific method() is called with a specific value.
	 */
	@Test
	public void verificationBasics() {

		// System Under Test (SUT)
		String stringMockValue1 = listMock.get(0);

		// Verify that the get() method is called ont listMock
		verify(listMock).get(0); // verify get() method call with arg 0
		verify(listMock).get(anyInt()); // verify get() method call with org.mockito.ArgumentMatchers.anyInt() arg
		verify(listMock, times(1)).get(anyInt()); // verify that the get() method is called only once with times(1)).get(anyInt()) arg
	}

	/**
	 * verificationBasics2()
	 * Verification tests: Important if values are not returned back, so they cannot be tested.
	 * Test if the specific method() is called with a specific value.
	 */
	@Test
	public void verificationBasics2() {

		// System Under Test (SUT)
		String stringMockValue1 = listMock.get(0);
		String stringMockValue2 = listMock.get(1);

		// Verify that the get() method is called ont listMock
		verify(listMock).get(0); // verify get() method call with arg 0
//		verify(listMock).get(anyInt()); // verify get() method call with org.mockito.ArgumentMatchers.anyInt() arg
//		verify(listMock, times(1)).get(anyInt()); // verify that the get() method is called only once with times(1) arg
		verify(listMock, times(2)).get(anyInt()); // verify that the get() method is called twice with times(2) arg
		verify(listMock, atLeast(1)).get(anyInt()); // verify that the get() method is called at least once with atLeast(1) arg
		verify(listMock, atLeastOnce()).get(anyInt()); // verify that the get() method is called at least once with atLeast(1) arg
		verify(listMock, atMost(2)).get(anyInt()); // verify that the get() method is called at most twice with atMost(2) arg
		verify(listMock, never()).get(2); // verify that the get(2) method is never called with never()).get(2) arg
	}


	/**
	 * argumentCapturing()
	 * UNit test with captured argument
	 */
	@Test
	public void argumentCapturing() {

		// System Under Test (SUT)
		listMock.add("Some String to be added to the list");

		// Verify the captured argument to be passed
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class); // init org.mockito.ArgumentCaptor for the String class
		verify(listMock).add(argumentCaptor.capture()); // argumentCaptor.capture(): capture the argument passed by the add() method

		assertEquals("Some String to be added to the list", argumentCaptor.getValue()); // ArgumentCaptor.getValue(): get the captured parameter

	}


	/**
	 * argumentCapturing()
	 * UNit test with multiple captured arguments
	 */
	@Test
	public void multipleArgumentCapturing() {

		// System Under Test (SUT)
		listMock.add("Some String 0");
		listMock.add("Some String 1");

		// Verify the captured all arguments to be passed using the add() method
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class); // init org.mockito.ArgumentCaptor for the String class
		verify(listMock, times(2)).add(argumentCaptor.capture()); // argumentCaptor.capture(): capture the argument passed by the add() method

		List<String> allValues = argumentCaptor.getAllValues(); // ArgumargumentCaptor.getAllValues(): get a List of all captured parameters
		assertEquals("Some String 0", allValues.get(0)); // test 1st argument passed to the allValues List
		assertEquals("Some String 1", allValues.get(1)); // test 2nd argument passed to the allValues List

	}
}
