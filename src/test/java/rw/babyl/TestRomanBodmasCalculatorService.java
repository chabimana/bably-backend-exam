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
public class TestRomanBodmasCalculatorService {

	@Autowired
	private IRomanBodmasCalculatorService romanBodmasCalculatorService;

	@Autowired
	private IRomanNumeralConvertorService convertorService;

	@Test
	public void testRomanBodmasCalculator() {
		Assert.assertEquals(100, romanBodmasCalculatorService.processNumeralExpression("100 * ( 2 + 12 ) / 14"));

		Assert.assertEquals(30, romanBodmasCalculatorService.processNumeralExpression("(3 + 5 ) * 3 + 6"));
	}

	@Test
	public void testRomanToNumeralConversion() {
		/*
		 * Assert.assertEquals("(3 + 4 ) * 10",
		 * romanBodmasCalculatorService.generateNumeralExpressionFromRomanExpression("(III + IV ) *X"));
		 */
		System.out.println(
				romanBodmasCalculatorService.generateNumeralExpressionFromRomanExpression("(XIII + IV ) * X - LIII"));
		Assert.assertEquals("( 13 + 4 ) * 10 - 53 ",
				romanBodmasCalculatorService.generateNumeralExpressionFromRomanExpression("(XIII + IV ) * X - LIII"));
	}

	@Test
	public void testArthimeticOperationsOnRomanExpresions() {
		Assert.assertEquals("VII", romanBodmasCalculatorService.calculateRomanExpression("III + IV"));
		Assert.assertEquals("XXIV", romanBodmasCalculatorService.calculateRomanExpression("(III + V ) * III"));
		Assert.assertEquals("XXX", romanBodmasCalculatorService.calculateRomanExpression("(III + V ) * III + VI"));
		Assert.assertEquals("LIV", romanBodmasCalculatorService.calculateRomanExpression("VI + II * (III + V ) * III"));

		Assert.assertEquals(
				convertorService.convertNumeralToRomanNumber(
						romanBodmasCalculatorService.processNumeralExpression("(13 + 4 ) * 10 - 53")),
				romanBodmasCalculatorService.calculateRomanExpression("(XIII + IV ) * X - LIII"));
	}
}
