package rw.babyl.util;

import java.util.List;

/**
 * @Author: chabiman
 * @FileName: PinkBuzzResponse.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.util
 * @ProjectName: babyl-backend-exam
 *
 */
public class FizzBuzzResponse {

	private List<String> pinkNumbers;

	private List<String> pinkBuzzNumbers;

	private List<String> others;

	/**
	 * @return the pinkNumbers
	 */
	public List<String> getPinkNumbers() {
		return pinkNumbers;
	}

	/**
	 * @return the pinkBuzzNumbers
	 */
	public List<String> getPinkBuzzNumbers() {
		return pinkBuzzNumbers;
	}

	/**
	 * @return the others
	 */
	public List<String> getOthers() {
		return others;
	}

	/**
	 * @param pinkNumbers the pinkNumbers to set
	 */
	public void setPinkNumbers(List<String> pinkNumbers) {
		this.pinkNumbers = pinkNumbers;
	}

	/**
	 * @param pinkBuzzNumbers the pinkBuzzNumbers to set
	 */
	public void setPinkBuzzNumbers(List<String> pinkBuzzNumbers) {
		this.pinkBuzzNumbers = pinkBuzzNumbers;
	}

	/**
	 * @param others the others to set
	 */
	public void setOthers(List<String> others) {
		this.others = others;
	}

}
