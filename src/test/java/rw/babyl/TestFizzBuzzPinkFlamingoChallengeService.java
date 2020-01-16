package rw.babyl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rw.babyl.service.fizzbuzz.IFizzBuzzPinkFlamingoService;

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
public class TestFizzBuzzPinkFlamingoChallengeService {

	@Autowired
	private IFizzBuzzPinkFlamingoService babylonService;

	/**
	 * Test square number positive.
	 */
	@Test
	public void testSquareNumberPositive() {
		Assert.assertTrue(babylonService.isPerfectSquare(4));
		Assert.assertFalse(babylonService.isPerfectSquare(10));
	}

	/**
	 * Test perfect square negative.
	 */
	@Test(expected = AssertionError.class)
	public void testPerfectSquareNegative() {
		Assert.assertTrue(babylonService.isPerfectSquare(3));
		Assert.assertFalse(babylonService.isPerfectSquare(9));
	}

	/**
	 * Test fibonacci number postive.
	 */
	@Test
	public void testFibonacciNumberPostive() {
		Assert.assertTrue(babylonService.isInFibonacciSequence(1));
		Assert.assertTrue(babylonService.isInFibonacciSequence(2));
		Assert.assertTrue(babylonService.isInFibonacciSequence(3));
		Assert.assertTrue(babylonService.isInFibonacciSequence(5));
	}

	/**
	 * Test fibonacci number negative.
	 */
	@Test(expected = AssertionError.class)
	public void testFibonacciNumberNegative() {
		Assert.assertTrue(babylonService.isInFibonacciSequence(4));
	}

	/**
	 * Test multiple of three challenge positive 1.
	 */
	@Test
	public void testMultipleOfThreeChallengePositive1() {
		List<Object> result = babylonService.fizzBuzzChallenge(0, 100);
		Assert.assertTrue(!result.isEmpty());

	}

	/**
	 * Test multiple of three challenge positive 2.
	 */
	@Test
	public void testMultipleOfThreeChallengePositive2() {
		List<Object> result = babylonService.fizzBuzzChallenge(100, 200);
		Assert.assertTrue(!result.isEmpty());
	}
}
