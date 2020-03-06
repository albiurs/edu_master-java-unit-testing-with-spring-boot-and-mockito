package com.in28minutes.unittesting.unittesting.busines;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SomeBusinessImplTest
 *
 * @link https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class SomeBusinessImplTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 1,2,3 });
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { });
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 5 });
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}