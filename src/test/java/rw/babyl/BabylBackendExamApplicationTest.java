package rw.babyl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rw.babyl.service.IBabylonService;

/**
 * @Author: chabiman
 * @FileName: BabylBackendExamApplicationTest.java
 * @Date: Jan 14, 2020
 * @Package: rw.babyl
 * @ProjectName: babyl-backend-exam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BabylBackendExamApplicationTest {

	@Autowired
	private IBabylonService babylonService;

	@Test
	public void testSquareNumberPositive() {
		Assert.assertTrue(babylonService.checkPerfectSqare(4));
		Assert.assertFalse(babylonService.checkPerfectSqare(10));
	}

	@Test(expected = AssertionError.class)
	public void testPerfectSquareNegative() {
		Assert.assertTrue(babylonService.checkPerfectSqare(3));
		Assert.assertFalse(babylonService.checkPerfectSqare(9));
	}

}
