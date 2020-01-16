package rw.babyl.service.romancalculator;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chabiman
 * @FileName: RomanBodmasCalculatorService.java
 * @Date: Jan 16, 2020
 * @Package: rw.babyl.service.romancalculator
 * @ProjectName: babyl-backend-exam
 *
 */
@Service
public class RomanBodmasCalculatorService implements IRomanBodmasCalculatorService {

	@Autowired
	private IRomanNumeralConvertorService convertorService;

	private Logger LOGGER = LoggerFactory.getLogger(RomanBodmasCalculatorService.class);

	/*
	 *
	 * @see rw.babyl.service.romancalculator.IRomanBodmasCalculatorService#calculateRomanExpression(java.lang.String)
	 */
	@Override
	public String calculateRomanExpressionResult(String romaExpression) {
		String numeralExpression = generateNumeralExpressionFromRomanExpression(romaExpression);
		int numeralResult = processNumeralExpression(numeralExpression);
		return convertorService.convertNumeralToRomanNumber(numeralResult);
	}

	/*
	 *
	 * @see
	 * rw.babyl.service.romancalculator.IRomanBodmasCalculatorService#generateNumeralExpressionFromRomanExpression(java.
	 * lang.String)
	 */
	@Override
	public String generateNumeralExpressionFromRomanExpression(String romanExpression) {
		StringBuilder numeralExpression = new StringBuilder();
		char[] tokens = romanExpression.toCharArray();
		for (int i = 0; i < tokens.length; i++) {
			if (isOperand(tokens[i])) {
				numeralExpression.append(tokens[i] + " ");
			} else if (isRomanCharacter(tokens[i])) {
				StringBuilder romanCharacter = new StringBuilder();
				while (i < tokens.length && isRomanCharacter(tokens[i])) {
					romanCharacter.append(tokens[i++]);
				}
				numeralExpression.append(convertorService.convertRomanToNumericNumber(romanCharacter.toString()) + " ");
			}
		}
		LOGGER.info("Numeral Expression: {}", numeralExpression);
		return numeralExpression.toString();
	}

	/*
	 *
	 * @see rw.babyl.service.romancalculator.IRomanBodmasCalculatorService#processRomanExpression(java.lang.String)
	 */
	@Override
	public int processNumeralExpression(String inputExpression) {
		LOGGER.info("Input Numeral Expression: {}", inputExpression);
		char[] tokens = inputExpression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuilder sbuf = new StringBuilder();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			} else if (tokens[i] == '(')
				ops.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(process(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
				while (!ops.empty() && checkPrecedence(tokens[i], ops.peek()))
					values.push(process(ops.pop(), values.pop(), values.pop()));
				ops.push(tokens[i]);
			}
		}
		while (!ops.empty())
			values.push(process(ops.pop(), values.pop(), values.pop()));

		return values.pop();

	}

	/**
	 * Process.
	 *
	 * @param operand the operand
	 * @param b       the b
	 * @param a       the a
	 * @return the int
	 */
	private int process(char operand, int b, int a) {
		switch (operand) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)
					throw new UnsupportedOperationException("Cannot divide by zero");
				return a / b;
			case '^':
				if (b == 0)
					return 1;
				return (calculatePower(b, a));
		}
		return 0;
	}

	/**
	 * Calculate power.
	 *
	 * @param b the b
	 * @param a the a
	 * @return the int
	 */
	private int calculatePower(int b, int a) {
		LOGGER.info("Variables: {} power of {}", a, b);
		int power = 1;
		for (int i = 0; i < b; i++) {
			power *= a;
		}
		return power;
	}

	/**
	 * Check precedence.
	 *
	 * @param operand_two   the operand two
	 * @param opoperand_one the opoperand one
	 * @return true, if successful
	 */
	private boolean checkPrecedence(char operand_two, char opoperand_one) {

		if (opoperand_one == '(' || opoperand_one == ')')
			return false;
		if ((operand_two == '*' || operand_two == '/') && (opoperand_one == '+' || opoperand_one == '-'))
			return false;
		else
			return true;
	}

	/**
	 * Checks if is roman character.
	 *
	 * @param c the c
	 * @return true, if is roman character
	 */
	private boolean isRomanCharacter(char c) {
		if (c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'D' || c == 'M') {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is operand.
	 *
	 * @param c the c
	 * @return true, if is operand
	 */
	private boolean isOperand(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '^')
			return true;
		return false;
	}

}
