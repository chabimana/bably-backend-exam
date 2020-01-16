package rw.babyl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rw.babyl.service.romancalculator.IRomanBodmasCalculatorService;

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

	@Test
	public void testRomanBodmasCalculator() {
		Assert.assertEquals(100, romanBodmasCalculatorService.processNumeralExpression("100 * ( 2 + 12 ) / 14"));
	}

	@Test
	public void testRomanToNumeralConversion() {
		Assert.assertEquals("(3+4)*10",
				romanBodmasCalculatorService.generateNumeralExpressionFromRomanExpression("(III + IV ) *X"));

		Assert.assertEquals("(13+4)*10-53",
				romanBodmasCalculatorService.generateNumeralExpressionFromRomanExpression("(XIII + IV ) * X - LIII"));
	}
}
