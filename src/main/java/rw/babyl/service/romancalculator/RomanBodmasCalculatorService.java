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
	public String calculateRomanExpression(String romaExpression) {
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
		StringBuffer numeralExpression = new StringBuffer();
		char[] tokens = romanExpression.toCharArray();
		for (int i = 0; i < tokens.length; i++) {
			if (isOperand(tokens[i])) {
				numeralExpression.append(tokens[i] + " ");
			} else if (isRomanCharacter(tokens[i])) {
				StringBuffer romanCharacter = new StringBuffer();
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
		// Add all numbers in the stack
		Stack<Integer> values = new Stack<Integer>();
		// Add all operands in the stack
		Stack<Character> ops = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;
			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}
			// Current token is an opening brace, push it to 'ops'
			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			// Closing brace encountered, solve entire brace
			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(process(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}
			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!ops.empty() && processPrecedence(tokens[i], ops.peek()))
					values.push(process(ops.pop(), values.pop(), values.pop()));
				ops.push(tokens[i]);
			}
		}
		while (!ops.empty())
			values.push(process(ops.pop(), values.pop(), values.pop()));

		return values.pop();

	}

	/**
	 * @param tokenBuffer2
	 * @return
	 */
	private int process(char op, int b, int a) {
		switch (op) {
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
		}
		return 0;
	}

	/**
	 * @param op1
	 * @param op2
	 * @return
	 */
	private boolean processPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	/**
	 * @param c
	 * @return
	 */
	private boolean isRomanCharacter(char c) {
		if (c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'D' || c == 'M') {
			return true;
		}
		return false;
	}

	/**
	 * @param c
	 * @return
	 */
	private boolean isOperand(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')
			return true;
		return false;
	}

}
