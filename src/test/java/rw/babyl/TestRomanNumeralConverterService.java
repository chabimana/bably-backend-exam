package rw.babyl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rw.babyl.service.romancalculator.IRomanBodmasCalculatorService;
import rw.babyl.service.romancalculator.IRomanNumeralConvertorService;

/**
 * @Author: chabiman
 * @FileName: TestRomanBodmasCalculatorService.java
 * @Date: Jan 15, 2020
 * @Package: rw.babyl
 * @ProjectName: babyl-backend-exam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRomanNumeralConverterService {

	@Autowired
	private IRomanBodmasCalculatorService calculatorService;

	@Autowired
	private IRomanNumeralConvertorService convertorService;

	@Test
	public void testRomanBodmasCalculator() {
		Assert.assertEquals(100, calculatorService.processNumeralExpression("100 * ( 2 + 12 ) / 14"));

		Assert.assertEquals(30, calculatorService.processNumeralExpression("(3 + 5 ) * 3 + 6"));
	}

	@Test
	public void testRomanToNumeralConversion() {

		Assert.assertEquals("( 3 + 4 ) * 10 ",
				calculatorService.generateNumeralExpressionFromRomanExpression("(III + IV ) *X"));
		System.out.println(calculatorService.generateNumeralExpressionFromRomanExpression("(XIII + IV ) * X - LIII"));
		Assert.assertEquals("( 13 + 4 ) * 10 - 53 ",
				calculatorService.generateNumeralExpressionFromRomanExpression("(XIII + IV ) * X - LIII"));
	}

	@Test
	public void testArthimeticOperationsOnRomanExpresions() {
		Assert.assertEquals("VII", calculatorService.calculateRomanExpressionResult("III + IV"));
		Assert.assertEquals("XXIV", calculatorService.calculateRomanExpressionResult("(III + V ) * III"));
		Assert.assertEquals("XXX", calculatorService.calculateRomanExpressionResult("(III + V ) * III + VI"));
		Assert.assertEquals("LIV", calculatorService.calculateRomanExpressionResult("VI + II * (III + V ) * III"));

		Assert.assertEquals(
				convertorService
						.convertNumeralToRomanNumber(calculatorService.processNumeralExpression("(13 + 4 ) * 10 - 53")),
				calculatorService.calculateRomanExpressionResult("(XIII + IV ) * X - LIII"));
	}

	@Test
	public void testPowerOperationOnRomanExpressions() {
		System.out.println(calculatorService.calculateRomanExpressionResult("V ^ II"));
		Assert.assertEquals("XXXI", calculatorService.calculateRomanExpressionResult("V ^ II +VI"));

		Assert.assertEquals("XXV", calculatorService.calculateRomanExpressionResult("V ^ (V - III )"));
	}
}
