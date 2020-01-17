package rw.babyl.util;

import org.hibernate.validator.constraints.Range;

/**
 * @Author: chabiman
 * @FileName: FIzzBuzzRequest.java
 * @Date: Jan 16, 2020
 * @Package: rw.babyl.util
 * @ProjectName: babyl-backend-exam
 *
 */
public class NumeralRequest {

	@Range(min = 0, max = 4000, message = "Can only convert numbers between 0 and 4000")
	private int number;

	/**
	 * @return the number
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

}
