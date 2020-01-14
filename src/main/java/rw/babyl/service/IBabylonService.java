/*
 * Copyright (c)  2018. Irembo
 *
 * All rights reserved.
 */

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
public interface IBabylonService {

	/**
	 * Check perfect sqare.
	 *
	 * @param number the number
	 * @return true, if successful
	 */
	public boolean checkPerfectSqare(int number);

	/**
	 * Checks if is fibonacci sequence.
	 *
	 * @param number the number
	 * @return true, if is fibonacci sequence
	 */
	public boolean isFibonacciSequence(int number);

	/**
	 * Multiple of three challenge.
	 *
	 * @param minNumber the min number
	 * @param maxNumber the max number
	 * @return the list
	 */
	public List<String> multipleOfThreeChallenge(int minNumber, int maxNumber);

}
