package rw.babyl;

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
		romanBodmasCalculatorService.processRomanExpression("7/1+(2*6+7)-(8*6)");
	}

}
