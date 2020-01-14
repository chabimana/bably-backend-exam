package rw.babyl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @Author: chabiman
 * @FileName: BabylService.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service
 * @ProjectName: babyl-backend-exam
 *
 */
@Service
public class FizzBuzzService implements IFizzBuzzService {

	/*
	 *
	 * @see rw.babyl.service.IBabylonService#checkPerfectSqare(int)
	 */
	@Override
	public boolean isPerfectSquare(int number) {
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
	public boolean isInFibonacciSequence(int number) {
		if (isPerfectSquare((int) (5 * (Math.pow(number, 2)) + 4))
				|| isPerfectSquare((int) (5 * (Math.pow(number, 2)) - 4)))
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
