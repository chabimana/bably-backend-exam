package rw.babyl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class TestRomanConverterService {

	@Autowired
	private IRomanNumeralConvertorService convertorService;

	@Test
	public void testRomanToNumeralConverter() {
		Assert.assertEquals(120, convertorService.convertRomanToNumericNumber("CXX"));

		Assert.assertEquals(30, convertorService.convertRomanToNumericNumber("XXX"));
	}

	@Test
	public void testNumeralToRomanConvrter() {
		Assert.assertEquals("XLIV", convertorService.convertNumeralToRomanNumber(44));

		Assert.assertEquals("CXXIV", convertorService.convertNumeralToRomanNumber(124));
	}

}
