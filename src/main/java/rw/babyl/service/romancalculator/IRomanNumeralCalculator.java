
package rw.babyl.service.romancalculator;

/**
 * @Author: chabiman
 * @FileName: IRomanNumeralCalculator.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
public interface IRomanNumeralCalculator {

	/**
	 * Convert numeral to roman number.
	 *
	 * @param numeralNumber the numeral number
	 * @return the string
	 */
	String convertNumeralToRomanNumber(int numeralNumber);

}
