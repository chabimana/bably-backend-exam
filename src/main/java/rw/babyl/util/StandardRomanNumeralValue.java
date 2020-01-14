/*
 * Copyright (c)  2018. Irembo
 *
 * All rights reserved.
 */

package rw.babyl.util;

/**
 * @Author: chabiman
 * @FileName: StarndardRomanCharacter.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl.util
 * @ProjectName: babyl-backend-exam
 *
 */
public class StandardRomanNumeralValue {

	private int numeralValue;

	private String romanValue;

	/**
	 * Instantiates a new standard roman numeral value.
	 *
	 * @param numeralValue the numeral value
	 * @param romanValue   the roman value
	 */
	public StandardRomanNumeralValue(int numeralValue, String romanValue) {
		this.numeralValue = numeralValue;
		this.romanValue = romanValue;
	}

	/**
	 * @return the numeralValue
	 */
	public int getNumeralValue() {
		return numeralValue;
	}

	/**
	 * @return the romanValue
	 */
	public String getRomanValue() {
		return romanValue;
	}

	/**
	 * @param numeralValue the numeralValue to set
	 */
	public void setNumeralValue(int numeralValue) {
		this.numeralValue = numeralValue;
	}

	/**
	 * @param romanValue the romanValue to set
	 */
	public void setRomanValue(String romanValue) {
		this.romanValue = romanValue;
	}

}
