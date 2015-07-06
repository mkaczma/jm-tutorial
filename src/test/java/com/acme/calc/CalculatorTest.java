package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void additionShouldReturnCorrectResult() {
		// given
		double firstNumber = 5.0;
		double secondNumber = 6.0;
		// when
		Double result = calculator.add(firstNumber, secondNumber);
		// then
		Assert.assertTrue(result == 11);
		Assert.assertFalse(result.isNaN());
	}

	@Test
	public void subtractionShouldReturnCorrectResult() {

		double firstNumber = 5.0;
		double secondNumber = 6.0;
		Double result = calculator.subtract(firstNumber, secondNumber);
		Assert.assertTrue(result == -1);
		Assert.assertFalse(result.isNaN());
	}

	@Test
	public void multiplicationShouldReturnCorrectResult() {

		double firstNumber = 5.0;
		double secondNumber = 6.0;
		Double result = calculator.multiply(firstNumber, secondNumber);
		Assert.assertTrue(result == 30);
		Assert.assertFalse(result.isNaN());
	}

	@Test(expected = DivisorCannotBeZeroException.class)
	public void divisionShouldReturnCorrectResult() {

		double firstNumber = 6.0;
		double secondNumber = 3.0;
		double zeroNumber = 0.0;

		calculator.divide(firstNumber, zeroNumber);
		Double result = calculator.divide(firstNumber, secondNumber);
		Assert.assertTrue(result == 2);
		Assert.assertFalse(result.isNaN());

	}

}
