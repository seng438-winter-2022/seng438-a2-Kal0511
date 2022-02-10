package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;

public class RangeTest {
	
	private Range constrainRangeTest;
	private Range containsRangeTest;

	@Before
	public void setUp() throws Exception {
		constrainRangeTest = new Range(2, 7);
		containsRangeTest = new Range(-11.5, 31.5);
	}
	
	
	// getCentralValue
	
	@Test
	public void centralValueShouldBeNegative() {
		Range values = new Range(-10, 5);
		assertEquals("The central value of -10 and 5 should be -2.5", -2.5, values.getCentralValue(), .01d);
	}

	@Test
	public void centralValueShouldBeZero() {
		Range values = new Range(-10, 10);
		assertEquals("The central value of -10 and 10 should be 0", 0, values.getCentralValue(), .01d);
	}
	
	@Test
	public void centralValueShouldBePositive() {
		Range values = new Range(-5, 10);
		assertEquals("The central value of -5 and 10 should be 2.5", 2.5, values.getCentralValue(), .01d);
	}
	
	
	// contains

	@Test
	public void containsTestForLessThanLowerBound() {
		assertEquals(containsRangeTest.contains(-13.1), false);

	}
	
	@Test
	public void containsTestForOnLowerBound() {
		assertEquals(containsRangeTest.contains(-11.1), true);
	}
	
	@Test
	public void containsTestForInBetweenBounds() {
		assertEquals(containsRangeTest.contains(0), true);
	}
	
	@Test
	public void containsTestForOnUpperBound() {
		assertEquals(containsRangeTest.contains(31.5), true);
	}
	
	@Test
	public void containsTestForMoreThanUpperBound() {
		assertEquals(containsRangeTest.contains(41.5), false);
	}
	
	
	// equals

	@Test
	public void equalsTestForSameRange() {
		Range values = new Range(-10, 10);
		Range results = new Range(-10, 10);
		assertEquals(values.equals(results), true);
	}
	
	@Test
	public void equalsTestForLowerRange() {
		Range values = new Range(-10, 10);
		Range results = new Range(-20, 10);
		assertEquals(values.equals(results), false);
	}
	
	@Test
	public void equalsTestForHigherRange() {
		Range values = new Range(-10, 10);
		Range results = new Range(-10, 20);
		assertEquals(values.equals(results), false);
	}
	
	
	// getLowerBound

	@Test
	public void getLowerBoundTest() {
		Range values = new Range(-10, 10);
		assertEquals("Lower bound should be -10", -10, values.getLowerBound(), .01d);
	}
	
	
	// getUpperBound
 
	@Test
	public void getUpperBoundTest() {
		Range values = new Range(-10, 10);
		assertEquals("Upper bound should be 10", 10, values.getUpperBound(), .01d);
	}
	

	// combine
	
	@Test
	public void combineTestIntersect() {
		Range test1, test2;
		Range result, expected;

		test1 = new Range(0, 10);
		test2 = new Range(5, 15);
		expected = new Range(0, 15);
		result = Range.combine(test1, test2);
		assertEquals(result, expected);
	}

	@Test
	public void combineTestNoOverlap() {
		Range test1, test2;
		Range result, expected;

		test1 = new Range(0, 10);
		test2 = new Range(15, 20);
		expected = new Range(0, 20);
		result = Range.combine(test1, test2);
		assertEquals(result, expected);
	}

	@Test
	public void combineTestNull() {
		Range test1, test2;
		Range result, expected;

		test1 = null;
		test2 = new Range(0, 10);
		expected = new Range(0, 10);
		result = Range.combine(test1, test2);
		assertEquals(result, expected);
	}
	

	// constrain
	
	@Test
	public void constrainTestInsideRange() {
		double result;
		result = constrainRangeTest.constrain(3);
		assertEquals(result, 3, 0.01d);
	}

	@Test
	public void constrainTestOutsideRangeAbove() {
		double result;
		result = constrainRangeTest.constrain(8);
		assertEquals(result, 7, 0.01d);
	}

	@Test
	public void constrainTestOutsideRangeBelow() {
		double result;
		result = constrainRangeTest.constrain(1);
		assertEquals(result, 2, 0.01d);
	}

	@Test
	public void constrainTestOnLower() {
		double result;
		result = constrainRangeTest.constrain(2);
		assertEquals(result, 2, 0.01d);
	}

	@Test
	public void constrainTestOnUpper() {
		double result;
		result = constrainRangeTest.constrain(7);
		assertEquals(result, 7, 0.01d);
	}

}
