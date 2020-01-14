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
public class PinkFlamingoResponse {

	private List<String> pinkNumbers;

	private List<String> pinkFlamingoNumbers;

	/**
	 * @return the pinkNumbers
	 */
	public List<String> getPinkNumbers() {
		return pinkNumbers;
	}

	/**
	 * @return the pinkFlamingoNumbers
	 */
	public List<String> getPinkFlamingoNumbers() {
		return pinkFlamingoNumbers;
	}

	/**
	 * @param pinkNumbers the pinkNumbers to set
	 */
	public void setPinkNumbers(List<String> pinkNumbers) {
		this.pinkNumbers = pinkNumbers;
	}

	/**
	 * @param pinkFlamingoNumbers the pinkFlamingoNumbers to set
	 */
	public void setPinkFlamingoNumbers(List<String> pinkFlamingoNumbers) {
		this.pinkFlamingoNumbers = pinkFlamingoNumbers;
	}

}
