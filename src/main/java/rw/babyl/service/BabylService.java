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
public class BabylService {

	private List<String> response = new ArrayList<String>();

	/**
	 * Prints the multiple of three challenge.
	 */
	public List<String> printMultipleOfThreeChallenge() {
		for (int i = 0; i <= 100; i++) {
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

	public static void main(String[] args) {
		BabylService babylService = new BabylService();
		List<String> res = babylService.printMultipleOfThreeChallenge();
		System.out.println(res.toString());
	}

}
