package com.acme.craft.fixme.refactoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimesGeneratorTest {

	private int MAX_VALUE;
	private int[] RESULT;

	@Before
	public void init() {
		MAX_VALUE = 0;
		RESULT = new int[0];
	}

	@Test
	public void emptyScopeTest() {
		givenEmptyThreshold();
		whenPrimesCalculated();
		thenPrimesFindedQuantity(0);
	}

	@Test
	public void onePrimeTest() {
		givenThreshold(2);
		whenPrimesCalculated();
		thenPrimesFindedQuantity(1);
		thenSelectedElementEquals(0, 2);
	}

	@Test
	public void firstTwoPrimesTest() {
		givenThreshold(3);
		whenPrimesCalculated();
		thenPrimesFindedQuantity(2);
		thenSelectedElementEquals(0, 2);
		thenSelectedElementEquals(1, 3);
	}

	@Test
	public void primesUnderOneHundredTest() {
		givenThreshold(100);
		whenPrimesCalculated();
		thenPrimesFindedQuantity(25);
		thenSelectedElementEquals(24, 97);
	}

	private void thenSelectedElementEquals(int selectedElement, int value) {
		Assert.assertEquals(value, RESULT[selectedElement]);
	}

	private void givenThreshold(int maxValue) {
		MAX_VALUE = maxValue;
	}

	private void thenPrimesFindedQuantity(int quantity) {
		Assert.assertEquals(quantity, RESULT.length);
	}

	private void whenPrimesCalculated() {
		RESULT = GeneratePrimes.generatePrimes(MAX_VALUE);
	}

	private void givenEmptyThreshold() {
		MAX_VALUE = 0;
	}

}
