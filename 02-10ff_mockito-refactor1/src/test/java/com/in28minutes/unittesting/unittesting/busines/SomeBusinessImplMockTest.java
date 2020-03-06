package com.in28minutes.unittesting.unittesting.busines;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * SomeBusinessImplTest
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeBusinessImplMockTest {


	// == fields ==
	SomeBusinessImpl business = new SomeBusinessImpl(); // create new instance of SomeBusinessImpl, where mocks have to be injected
	SomeDataService dataServiceMock = mock(SomeDataService.class); // Mockito.mock > create a mock to be injected for the dataService


	// == set-up and tear-down ==
	@BeforeEach
	void setUp() {
		// initialize SomeBusinessImpl.someDataService by calling SomeBusinessImpl.setSomeDataService using the dataServiceMock
		business.setSomeDataService(dataServiceMock);
	}

	@AfterEach
	void tearDown() {
	}


	// == JUnit tests ==
	/**
	 * calculateSumUsingDataService_basic()
	 * Standard JUnit test, testing against basic array.
	 */
	@Test
	void calculateSumUsingDataService_basic() {

		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1,2,3 });
		assertEquals(6, business.calculateSumUsingDataService(), 0);
	}

	/**
	 * calculateSumUsingDataService_empty()
	 * Standard JUnit test, testing against an empty array.
	 */
	@Test
	void calculateSumUsingDataService_empty() {

		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {  });
		assertEquals(0, business.calculateSumUsingDataService(), 0);
	}

	/**
	 * calculateSumUsingDataService_oneValue()
	 * Standard JUnit test, testing against an array containing one value only.
	 */
	@Test
	void calculateSumUsingDataService_oneValue() {

		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataService(), 0);
	}
}