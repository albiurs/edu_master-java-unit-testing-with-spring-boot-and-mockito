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


	// == set-up and tear-down ==
	@BeforeEach
	void setUp() {
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
		// create new instance of SomeBusinessImpl, where mocks have to be injected
		SomeBusinessImpl business = new SomeBusinessImpl();

		// Mockito.mock > create a mock to be injected for the dataService
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1,2,3 });

		// initialize SomeBusinessImpl.someDataService by calling SomeBusinessImpl.setSomeDataService using the dataServiceMock
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * calculateSumUsingDataService_empty()
	 * Standard JUnit test, testing against an empty array.
	 */
	@Test
	void calculateSumUsingDataService_empty() {
		// create new instance of SomeBusinessImpl, where mocks have to be injected
		SomeBusinessImpl business = new SomeBusinessImpl();

		// Mockito.mock > create a mock to be injected for the dataService
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {  });

		// initialize SomeBusinessImpl.someDataService by calling SomeBusinessImpl.setSomeDataService using the dataServiceMock
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * calculateSumUsingDataService_oneValue()
	 * Standard JUnit test, testing against an array containing one value only.
	 */
	@Test
	void calculateSumUsingDataService_oneValue() {
		// create new instance of SomeBusinessImpl, where mocks have to be injected
		SomeBusinessImpl business = new SomeBusinessImpl();

		// Mockito.mock > create a mock to be injected for the dataService
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		// when(myServiceMock.classToBeCalled()) is called, thenReturn(mockParameterToBeTestedAgainst)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });

		// initialize SomeBusinessImpl.someDataService by calling SomeBusinessImpl.setSomeDataService using the dataServiceMock
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}