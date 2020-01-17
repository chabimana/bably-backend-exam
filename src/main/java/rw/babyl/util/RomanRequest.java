package rw.babyl.util;

import javax.validation.constraints.NotNull;

/**
 * @Author: chabiman
 * @FileName: FIzzBuzzRequest.java
 * @Date: Jan 16, 2020
 * @Package: rw.babyl.util
 * @ProjectName: babyl-backend-exam
 *
 */
public class RomanRequest {

	@NotNull(message = "Write down the expression")
	private String romanExpression;

	/**
	 * @return the romanExpression
	 */
	public String getRomanExpression() {
		return this.romanExpression;
	}

	/**
	 * @param romanExpression the romanExpression to set
	 */
	public void setRomanExpression(String romanExpression) {
		this.romanExpression = romanExpression;
	}

}
