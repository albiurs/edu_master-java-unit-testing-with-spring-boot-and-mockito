package com.in28minutes.unittesting.unittesting.busines;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

/**
 * SomeBusinessImpl
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
public class SomeBusinessImpl {


	private SomeDataService someDataService;


	// == public methods ==
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value:data) {
			sum += value;
		}
		return sum;
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		return sum;
	}


	// == setters ==
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
}
