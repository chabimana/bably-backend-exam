package rw.babyl.util;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@Pattern(
			regexp = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$",
				message = "Invalid Roman Number")
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
