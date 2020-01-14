/*
 * Copyright (c)  2018. Irembo
 *
 * All rights reserved.
 */

package rw.babyl.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chabiman
 * @FileName: BabylService.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service
 * @ProjectName: babyl-backend-exam
 *
 */
public class BabylService implements IBabylonService {

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#checkPerfectSqare(int)
	 */
	@Override
	public boolean checkPerfectSqare(int number) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#isFibonacciSequence(int)
	 */
	@Override
	public boolean isFibonacciSequence(int number) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#multipleOfThreeChallenge(int, int)
	 */
	@Override
	public List<String> multipleOfThreeChallenge(int minNumber, int maxNumber) {
		List<String> response = new ArrayList<>();
		for (int i = minNumber; i <= maxNumber; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				response.add("Fizz");
			} else if (i % 3 == 0 && i % 5 == 0) {
				response.add("FizzBuzz");
			} else {
				response.add(String.valueOf(i));
			}
		}
		return response;
	}
}
