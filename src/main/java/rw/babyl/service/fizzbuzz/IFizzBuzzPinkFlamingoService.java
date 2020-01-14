package rw.babyl.service.fizzbuzz;

import java.util.List;

/**
 * @Author: chabiman
 * @FileName: IBabylonService.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service
 * @ProjectName: babyl-backend-exam
 *
 */
public interface IFizzBuzzPinkFlamingoService {

	/**
	 * Checks if is perfect square.
	 *
	 * @param number the number
	 * @return true, if is perfect square
	 */
	boolean isPerfectSquare(int number);

	/**
	 * Checks if is in fibonacci sequence.
	 *
	 * @param number the number
	 * @return true, if is in fibonacci sequence
	 */
	boolean isInFibonacciSequence(int number);

	/**
	 * Fizz buzz challenge.
	 *
	 * @param minNumber the min number
	 * @param maxNumber the max number
	 * @return the list
	 */
	List<Object> fizzBuzzChallenge(int minNumber, int maxNumber);

	/**
	 * Pink flamingo challenge.
	 *
	 * @param minNummber the min nummber
	 * @param maxNumber  the max number
	 * @return the list
	 */
	List<Object> pinkFlamingoChallenge(int minNummber, int maxNumber);

}
