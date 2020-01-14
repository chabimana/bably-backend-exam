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
public class FizzBuzzPinkFlamingoService implements IFizzBuzzPinkFlamingoService {

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
	public List<Object> fizzBuzzChallenge(int minNumber, int maxNumber) {
		List<Object> response = new ArrayList<>();
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
			} else if (i % 3 != 0 && i % 5 == 0) {
				response.add("Buzz");
			} else {
				response.add(i);
			}
		}
		return response;
	}

	/*
	 *
	 * @see rw.babyl.service.IFizzBuzzService#pinkFlamingoChallenge(int, int)
	 */
	@Override
	public List<Object> pinkFlamingoChallenge(int minNumber, int maxNumber) {

		List<Object> response = new ArrayList<>();

		for (int i = minNumber; i <= maxNumber; i++) {
			if (i % 3 == 0 && i % 5 != 0)
				response.add("Fizz");
			else if (i % 3 == 0 && i % 5 == 0)
				response.add("FizzBuzz");
			else if (i % 3 != 0 && i % 5 == 0)
				response.add("Buzz");
			else if (isInFibonacciSequence(i) && i % 5 != 0 && i % 3 != 0)
				response.add("Pink");
			else if (isInFibonacciSequence(i) && i % 5 == 0 && i % 3 == 0)
				response.add("Pink Flamingo");
			else
				response.add(i);
		}
		return response;
	}
}
