
package rw.babyl.service.romancalculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rw.babyl.util.StandardRomanNumeralValue;

/**
 * @Author: chabiman
 * @FileName: RomanNumeralCalculatorService.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
@Service
public class RomanNumeralCalculatorService implements IRomanNumeralCalculatorService {

	/*
	 *
	 * @see rw.babyl.service.romancalculator.IRomanNumeralCalculatorService#convertNumeralToRomanNumber(int)
	 */
	@Override
	public String convertNumeralToRomanNumber(int numeralNumber) {

		List<StandardRomanNumeralValue> masterList = generateMasterData();

		// The number to be returned
		StringBuilder romanNumber = new StringBuilder();

		for (StandardRomanNumeralValue value : masterList) {
			while (value.getNumeralValue() <= numeralNumber) {
				romanNumber.append(value.getRomanValue());
				numeralNumber = numeralNumber - value.getNumeralValue();
			}
		}
		return romanNumber.toString();
	}

	/*
	 *
	 * @see
	 * rw.babyl.service.romancalculator.IRomanNumeralCalculatorService#convertRomanToNumericNumber(java.lang.String)
	 */
	@Override
	public int convertRomanToNumericNumber(String romanNumber) {
		int numeralValue = 0;
		List<StandardRomanNumeralValue> masterList = generateMasterData();
		int i = 0;
		while (romanNumber.length() > 0 && i < masterList.size()) {
			String romanCharacter = masterList.get(i).getRomanValue();
			if (romanNumber.startsWith(romanCharacter)) {
				System.out.println(romanNumber + " " + masterList.get(i).getNumeralValue() + " ksksks");
				numeralValue += masterList.get(i).getNumeralValue();
				romanNumber = romanNumber.substring(masterList.get(i).getRomanValue().length());
			} else
				i++;
		}
		return numeralValue;
	}

	public List<StandardRomanNumeralValue> generateMasterData() {

		List<StandardRomanNumeralValue> masterList = new ArrayList<>();

		masterList.add(new StandardRomanNumeralValue(1000, "M"));
		masterList.add(new StandardRomanNumeralValue(900, "CM"));
		masterList.add(new StandardRomanNumeralValue(500, "D"));
		masterList.add(new StandardRomanNumeralValue(400, "CD"));
		masterList.add(new StandardRomanNumeralValue(100, "C"));
		masterList.add(new StandardRomanNumeralValue(90, "XC"));
		masterList.add(new StandardRomanNumeralValue(50, "L"));
		masterList.add(new StandardRomanNumeralValue(40, "XL"));
		masterList.add(new StandardRomanNumeralValue(10, "X"));
		masterList.add(new StandardRomanNumeralValue(9, "IX"));
		masterList.add(new StandardRomanNumeralValue(5, "V"));
		masterList.add(new StandardRomanNumeralValue(4, "IV"));
		masterList.add(new StandardRomanNumeralValue(1, "I"));

		return masterList;

	}

	public static void main(String[] args) {
		RomanNumeralCalculatorService service = new RomanNumeralCalculatorService();

		System.out.println(service.convertNumeralToRomanNumber(36));
		System.out.println(service.convertRomanToNumericNumber("XLIV"));
	}

}
