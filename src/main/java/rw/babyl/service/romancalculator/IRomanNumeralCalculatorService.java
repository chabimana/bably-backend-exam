
package rw.babyl.service.romancalculator;

/**
 * @Author: chabiman
 * @FileName: IRomanNumeralCalculator.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
public interface IRomanNumeralCalculatorService {

	/**
	 * This method converts numeral value into its corresponding roman number. It only supports numbers between 0 and
	 * 4000. Convert numeral to roman number.
	 *
	 * @param numeralNumber the numeral number
	 * @return the string
	 */
	String convertNumeralToRomanNumber(int numeralNumber);

	/**
	 * Convert roman to numeric number.
	 *
	 * @param romanNumber the roman number
	 * @return the int
	 */
	int convertRomanToNumericNumber(String romanNumber);

}
