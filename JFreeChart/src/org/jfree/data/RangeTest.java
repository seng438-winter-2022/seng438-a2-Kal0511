package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class contains test cases used for testing the functionality
 * of the RangeType class from the JFreechart application
 */
public class RangeTest {

  // private field used by some methods to test the constrain() method in the
  // RangeType class
  private Range constrainRangeTest;
  // private field used by some methods to test the contains() method in the
  // RangeType class
  private Range containsRangeTest;

  @Before
  public void setUp() throws Exception {
    constrainRangeTest = new Range(2, 7);
    containsRangeTest = new Range(-11.5, 31.5);
  }

  // getCentralValue

  @Test
  /**
   * A method testing the getCentralValue() method for a negative output
   */
  public void centralValueShouldBeNegative() {
    Range values = new Range(-10, 5);
    assertEquals("The central value of -10 and 5 should be -2.5", -2.5, values.getCentralValue(), .01d);
  }

  @Test
  /**
   * A method testing the getCentralValue() method for a zero output
   */
  public void centralValueShouldBeZero() {
    Range values = new Range(-10, 10);
    assertEquals("The central value of -10 and 10 should be 0", 0, values.getCentralValue(), .01d);
  }

  @Test
  /**
   * A method testing the getCentralValue() method for a postive output
   */
  public void centralValueShouldBePositive() {
    Range values = new Range(-5, 10);
    assertEquals("The central value of -5 and 10 should be 2.5", 2.5, values.getCentralValue(), .01d);
  }

  // contains

  @Test
  /**
   * A method testing the contains() method for a value that is smaller than the
   * lower boundary of a Range object
   */
  public void containsTestForLessThanLowerBound() {
    assertEquals(containsRangeTest.contains(-13.1), false);

  }

  @Test
  /**
   * A method testing the contains() method for a value that is within the lower
   * boundary of a Range object
   */
  public void containsTestForOnLowerBound() {
    assertEquals(containsRangeTest.contains(-11.1), true);
  } // ^^^ why not change -11.1 to -11.5 to cover the boundary?

  @Test
  /**
   * A method testing the contains() method for a value that is within
   * the boundary of a Range object
   */
  public void containsTestForInBetweenBounds() {
    assertEquals(containsRangeTest.contains(0), true);
  }

  @Test
  /**
   * A method testing the contains() method for a value that is
   * equal to the upper bound limit of a Range object
   */
  public void containsTestForOnUpperBound() {
    assertEquals(containsRangeTest.contains(31.5), true);
  }

  @Test
  /**
   * A method testing the contains() method for a value that is
   * greater than the upper bound of a Range object
   */
  public void containsTestForMoreThanUpperBound() {
    assertEquals(containsRangeTest.contains(41.5), false);
  }

  @Test
  /**
   * A method testing the contains() method for a value that is
   * equal to the minimum double value set as the upper bound
   * of a Range object
   */
  public void containsTestMin() {
    Range minRange = new Range(0, Double.MIN_VALUE);
    assertEquals(minRange.contains(Double.MIN_VALUE), true);
  }

  @Test
  /**
   * A method testing the contains() method for a value that is
   * equal to the maximum double value set as the upper bound
   * of a Range object
   */
  public void containsTestMax() {
    Range minRange = new Range(0, Double.MAX_VALUE);
    assertEquals(minRange.contains(Double.MAX_VALUE), true);
  }

  // equals

  @Test

  /**
   * A method testing the equals method for equality
   * between two Range objects
   */
  public void equalsTestForSameRange() {
    Range values = new Range(-10, 10);
    Range results = new Range(-10, 10);
    assertEquals(values.equals(results), true);
  }

  @Test
  /**
   * A method testing the equals method for inequality
   * between two Range objects using a lower range
   * for the expecteed result
   */
  public void equalsTestForLowerRange() {
    Range values = new Range(-10, 10);
    Range results = new Range(-20, 10);
    assertEquals(values.equals(results), false);
  }

  /**
   * A method testing the equals method for inequality
   * between two Range objects using a higher range
   * for the expecteed result
   */
  @Test
  public void equalsTestForHigherRange() {
    Range values = new Range(-10, 10);
    Range results = new Range(-10, 20);
    assertEquals(values.equals(results), false);
  }

  // getLowerBound

  /**
   * A method testing the getLowerBound() method for
   * the correct lower bound of a Range object
   */
  @Test
  public void getLowerBoundTest() {
    Range values = new Range(-10, 10);
    assertEquals("Lower bound should be -10", -10, values.getLowerBound(), .01d);
  }

  // getUpperBound

  /**
   * A method testing the getUpperBound() method for
   * the correct upper bound of a Range object
   */
  @Test
  public void getUpperBoundTest() {
    Range values = new Range(-10, 10);
    assertEquals("Upper bound should be 10", 10, values.getUpperBound(), .01d);
  }

  // combine

  /**
   * A method testing the combine() method for the
   * the correct combination of two Range objects
   */
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

  /**
   * A method testing the combine() method for the
   * the correct combination of two Range objects
   * with no overlap
   */
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

  /**
   * A method testing the combine() method for the
   * the correct combination of a null Range object
   * and an initialized Range object
   */
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

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value. This value is within the range of the Range
   * object
   */
  @Test
  public void constrainTestInsideRange() {
    double result;
    result = constrainRangeTest.constrain(3);
    assertEquals(result, 3, 0.01d);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value. The value is greater than the range of the
   * Range
   * object
   */
  @Test
  public void constrainTestOutsideRangeAbove() {
    double result;
    result = constrainRangeTest.constrain(8);
    assertEquals(result, 7, 0.01d);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value.
   */
  @Test
  public void constrainTestOutsideRangeBelow() {
    double result;
    result = constrainRangeTest.constrain(1);
    assertEquals(result, 2, 0.01d);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value. The value compared is equal to the lower
   * range of the Range object
   */
  @Test
  public void constrainTestOnLower() {
    double result;
    result = constrainRangeTest.constrain(2);
    assertEquals(result, 2, 0.01d);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value. The value compared is equal to the upper
   * range of the Range object
   */
  @Test
  public void constrainTestOnUpper() {
    double result;
    result = constrainRangeTest.constrain(7);
    assertEquals(result, 7, 0.01d);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value using the minimum double value for comparison
   */
  @Test
  public void constrainTestOnMin() {
    double result = Double.MIN_VALUE;
    double precision = 0.00000000000000000000000000000000000000000000001d;
    Range minRange = new Range(0, Double.MIN_VALUE);

    assertEquals(result, minRange.constrain(result), precision);
  }

  /**
   * A method testing the constrain() method for value within the range that is
   * closest to the specified value using the maximum double value for comparison
   */
  @Test
  public void constrainTestOnMax() {
    double result = Double.MAX_VALUE;
    double precision = 0.00000000000000000000000000000000000000000000001d;
    Range minRange = new Range(0, Double.MAX_VALUE);
    assertEquals(result, minRange.constrain(result), precision);

  }

}
