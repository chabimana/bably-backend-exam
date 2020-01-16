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
	 * @param inputExpression
	 * @return
	 */
	int processNumeralExpression(String inputExpression);

	/**
	 * @param romanExpression
	 * @return
	 */
	String generateNumeralExpressionFromRomanExpression(String romanExpression);

	/**
	 * @param romaExpression
	 * @return
	 */
	String calculateRomanExpression(String romaExpression);

}
