package rw.babyl.service;

import java.util.List;

/**
 * @Author: chabiman
 * @FileName: IBabylonService.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service
 * @ProjectName: babyl-backend-exam
 *
 */
public interface IFizzBuzzService {

	/**
	 * Checks if is perfect square.
	 *
	 * @param number the number
	 * @return true, if is perfect square
	 */
	public boolean isPerfectSquare(int number);

	/**
	 * Checks if is in fibonacci sequence.
	 *
	 * @param number the number
	 * @return true, if is in fibonacci sequence
	 */
	public boolean isInFibonacciSequence(int number);

	/**
	 * Multiple of three challenge.
	 *
	 * @param minNumber the min number
	 * @param maxNumber the max number
	 * @return the list
	 */
	public List<String> multipleOfThreeChallenge(int minNumber, int maxNumber);

}
