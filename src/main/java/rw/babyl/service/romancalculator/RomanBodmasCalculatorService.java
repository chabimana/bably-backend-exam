package rw.babyl.service.romancalculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @Author: chabiman
 * @FileName: RomanBodmasCalculatorService.java
 * @Date: Jan 15, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
@Service
public class RomanBodmasCalculatorService implements IRomanBodmasCalculatorService {

	private StringBuffer tokenBuffer;

	private StringBuffer parentheseToken;

	/*
	 *
	 * @see rw.babyl.service.romancalculator.IRomanBodmasCalculatorService#processRomanExpression(java.lang.String)
	 */
	@Override
	public int processRomanExpression(String inputExpression) {
		char[] characters = inputExpression.toCharArray();
		List<String> tokens = new ArrayList<>();
		for (int i = 0; i < characters.length; i++) {

			tokenBuffer = new StringBuffer();
			while (i < characters.length && characters[i] != '(' && characters[i] != ')') {
				tokenBuffer.append(characters[i]);
				i++;
			}
			String processed = process(tokenBuffer.toString());
			tokens.add(tokenBuffer.toString());
		}
		System.out.println(tokens);
		return 0;
	}

	/**
	 * @param tokenBuffer2
	 * @return
	 */
	private String process(String data) {
		char[] number = data.toCharArray();
		StringBuffer resultBuffer = new StringBuffer();
		if (number.length == 1)
			return resultBuffer.append(number[0]).toString();
		else if (muchOperands(number))
			return resultBuffer.append(number[0]).toString();
		else {

		}
	}

	/**
	 * @param number
	 * @return
	 */
	private boolean muchOperands(char[] number) {
		int operands = 0;
		int digits = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] >= '0' && number[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				while (i < number.length && number[i] >= '0' && number[i] <= '9')
					sbuf.append(number[i++]);
				digits++;
			} else {
				operands++;
			}
		}
		if (operands == digits || operands > digits)
			return true;
		return false;
	}
}
