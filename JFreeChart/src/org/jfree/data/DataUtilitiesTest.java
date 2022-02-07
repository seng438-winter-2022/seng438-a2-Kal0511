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
	public void test() {

	}

//	@Test
//	void calculateColumnTotalTest(){
//		final DefaultKeyedValues2D values = context.mock(DefaultKeyedValues2D.class);
//		double result = DataUtilities.calculateColumnTotal(values, 0);
//	}

	@Test
	public void calculateColumnTotalForTwoValues() {
		Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getColumnCount();
				will(returnValue(1));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 10.0, .000000001d);
	}

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
