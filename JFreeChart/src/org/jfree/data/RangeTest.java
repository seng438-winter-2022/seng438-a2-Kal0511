package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.*;
import org.junit.*;

public class RangeTest {

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

	@Test
	public void centralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}

	@Test
	public void containsTest() {
		double low = -11.1;
		double high = 31.5;
		Range test = new Range(low, high);
		assertEquals(test.contains(-13.1), false);
		assertEquals(test.contains(-11.1), true);
		assertEquals(test.contains(0), true);
		assertEquals(test.contains(31.5), true);
		assertEquals(test.contains(41.5), false);
	}
	
	@Test
	public void equalsTest() {
		Range values1 = new Range(-10, 10);
		Range values2 = new Range(-10, 20);
		Range values3 = new Range(-20, 10);
		
		assertEquals(values1.equals(values1), true);
		assertEquals(values1.equals(values2), false);
		assertEquals(values1.equals(values3), false);
	}
	
	@Test
	public void getLowerBoundTest() {
		Range values = new Range(-10, 10);
		assertEquals("Lower bound should be -10", -10, values.getLowerBound(), .000000001d);
	}
	
	@Test
	public void getUpperBound() {
		Range values = new Range(-10, 10);
		assertEquals("Upper bound should be 10", 10, values.getUpperBound(), .000000001d);
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
		Range test1;
		double result;
		
		test1 = new Range(2, 7);
		result = test1.constrain(3);
		assertEquals(result, 3, 0.01d);
	}
	
	@Test
	public void constrainTestOutsideRangeAbove() {
		Range test1;
		double result;
		
		test1 = new Range(2, 7);
		result = test1.constrain(8);
		assertEquals(result, 7, 0.01d);
	}
	
	@Test
	public void constrainTestOutsideRangeBelow() {
		Range test1;
		double result;
		
		test1 = new Range(2, 7);
		result = test1.constrain(1);
		assertEquals(result, 2, 0.01d);
	}
	
	@Test
	public void constrainTestOnLower() {
		Range test1;
		double result;
		
		test1 = new Range(2, 7);
		result = test1.constrain(2);
		assertEquals(result, 2, 0.01d);
	}
	
	@Test
	public void constrainTestOnUpper() {
		Range test1;
		double result;
		
		test1 = new Range(2, 7);
		result = test1.constrain(7);
		assertEquals(result, 7, 0.01d);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
