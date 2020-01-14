package rw.babyl;

import java.util.List;

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

	@Test
	public void testFibonacciNumberPostive() {
		Assert.assertTrue(babylonService.isFibonacciSequence(1));
		Assert.assertTrue(babylonService.isFibonacciSequence(2));
		Assert.assertTrue(babylonService.isFibonacciSequence(3));
		Assert.assertTrue(babylonService.isFibonacciSequence(5));
	}

	@Test(expected = AssertionError.class)
	public void testFibonacciNumberNegative() {
		Assert.assertTrue(babylonService.isFibonacciSequence(4));
	}

	@Test
	public void testMultipleOfThreeChallengePositive1() {
		List<String> result = babylonService.multipleOfThreeChallenge(0, 100);

		for (String string : result) {
			System.out.println(string);
		}
	}

	@Test
	public void testMultipleOfThreeChallengePositive2() {
		List<String> result = babylonService.multipleOfThreeChallenge(100, 0);

		for (String string : result) {
			System.out.println(string);
		}
	}
}
