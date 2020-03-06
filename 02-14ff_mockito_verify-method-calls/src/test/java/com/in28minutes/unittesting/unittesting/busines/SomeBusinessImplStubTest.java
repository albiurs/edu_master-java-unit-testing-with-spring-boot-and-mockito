package com.in28minutes.unittesting.unittesting.busines;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * SomeDataServiceStub
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1,2,3 };
	}
}


/**
 * SomeDataServiceEmptyStub
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}
}


/**
 * SomeDataServiceStub
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeDataServiceOneElementStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}
}


/**
 * SomeBusinessStubTest
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeBusinessImplStubTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}