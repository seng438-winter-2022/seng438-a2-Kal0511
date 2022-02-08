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

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
