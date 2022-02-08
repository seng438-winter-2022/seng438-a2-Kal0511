package org.jfree.data;

import static org.junit.Assert.*;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesTest {
	private Mockery mockingContext;

	@Before
	public void setUp() {
		mockingContext = new Mockery();
	}

	@Test
	public void createNumberArrayTest() {
		for (int m = 0; m < 10; m++) {
			double[] array = new double[m];
			for (int i = 0; i < m; i++) {
				array[i] = i;
			}
			Number[] result = DataUtilities.createNumberArray(array);
			assertEquals(array.length, result.length);
			for (int i = 0; i < m; i++) {
				assertEquals(array[i], result[i]);
			}
		}
	}

	@Test
	public void createNumberArray2DTest() {
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 10; n++) {
				double[][] array = new double[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						array[i][j] = i + j;
					}
				}
				Number[][] result = DataUtilities.createNumberArray2D(array);
				assertEquals(array.length, result.length);
				for (int i = 0; i < m; i++) {
					assertEquals(array[i].length, result[i].length);
					for (int j = 0; j < n; j++) {
					assertEquals(array[i][j], result[i][j]);
					}
				}
			}
		}
	}
	
	@Test
	public void equalTest() {
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 10; n++) {
				double[][] array1 = new double[m][n];
				double[][] array2 = new double[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						array1[i][j] = i + j;
						array2[i][j] = i + j;
					}
				}
				assertEquals(DataUtilities.equal(array1, array2), true);
				if (m > 0 && n > 0) {
					array1[0][0] = -1.55;
					assertEquals(DataUtilities.equal(array1, array2), false);
				}
			}
		}
	}
	
	@Test
	public void getCumulativePercentagesTest(){
		KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
//				oneOf(values).getRowCount(); will(returnValue(2));
//				oneOf(values).getColumnCount();
//				will(returnValue(1));
//				oneOf(values).getValue(0, 0);
//				will(returnValue(7.5));
//				oneOf(values).getValue(1, 0);
//				will(returnValue(2.5));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
	}

//	@Test
//	public void calculateColumnTotalForTwoValues() {
//		Values2D values = mockingContext.mock(Values2D.class);
//		mockingContext.checking(new Expectations() {
//			{
//				oneOf(values).getRowCount(); will(returnValue(2));
////				oneOf(values).getColumnCount();
////				will(returnValue(1));
////				oneOf(values).getValue(0, 0);
////				will(returnValue(7.5));
////				oneOf(values).getValue(1, 0);
////				will(returnValue(2.5));
//			}
//		});
//		double result = DataUtilities.calculateColumnTotal(values, 0);
//		assertEquals(result, 10.0, .000000001d);
//	}

	@Test
	public void cloneTest() {
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 10; n++) {
				double[][] array = new double[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						array[i][j] = i + j * 1.2;
					}
				}
				double[][] result = DataUtilities.clone(array);
				assertArrayEquals(result, array);
				if (m > 0 && n > 0) {
					array[0][0] = -1.55;
					assertNotEquals(array, result);
				}
			}
		}
	}
}
