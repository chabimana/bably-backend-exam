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
		int square = (int) Math.sqrt(number);
		if (square * square == number)
			return true;
		return false;
	}

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#isFibonacciSequence(int)
	 */
	@Override
	public boolean isFibonacciSequence(int number) {
		if (checkPerfectSqare((int) (5 * (Math.pow(number, 2)) + 4))
				|| checkPerfectSqare((int) (5 * (Math.pow(number, 2)) - 4)))
			return true;
		return false;
	}

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#multipleOfThreeChallenge(int, int)
	 */
	@Override
	public List<String> multipleOfThreeChallenge(int minNumber, int maxNumber) {
		List<String> response = new ArrayList<>();
		int tempNumber;
		if (minNumber > maxNumber) {
			// swap the number
			tempNumber = minNumber;
			maxNumber = minNumber;
			minNumber = tempNumber;
		}

		// loop and find multiple of 3 and others that meet proposed condition
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
