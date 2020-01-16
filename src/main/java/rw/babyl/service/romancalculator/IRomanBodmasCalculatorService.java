package rw.babyl.service.romancalculator;

/**
 * @Author: chabiman
 * @FileName: IRomanBodmasCalculator.java
 * @Date: Jan 15, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
public interface IRomanBodmasCalculatorService {

	/**
	 * Process numeral expression.T <b>This method</b> was extended from the tutorial I took from
	 * https://www.geeksforgeeks.org/expression-evaluation/. My work was the extension of what the explained in their
	 * algorthm and adding missing operations (power)
	 *
	 *
	 * @param inputExpression the input expression
	 * @return the int
	 */
	int processNumeralExpression(String inputExpression);

	/**
	 * Generate numeral expression from roman expression.
	 * 
	 * @param romanExpression the roman expression
	 * @return the string
	 */
	String generateNumeralExpressionFromRomanExpression(String romanExpression);

	/**
	 * Calculate roman expression result. This is the main method that accepts a roman expression (roman numbers and
	 * operands) and processes it and returns the roman value of the result. It call many utils methods that helps in
	 * parsing, converting and processing the operations and then returns the result
	 * 
	 * @Step1: get the expression
	 * @Step2: convert it to numeral one by calling a method that does that.
	 * @Step3: call a method that calculates the result with a numeral expression.
	 * @Step4: convert a returned numeral result to roman expression then.
	 * @Step5: return the result
	 *
	 * @param romaExpression the roma expression
	 * @return the string
	 */
	String calculateRomanExpressionResult(String romaExpression);

}
