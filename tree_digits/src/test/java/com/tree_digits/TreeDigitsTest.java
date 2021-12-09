package com.tree_digits;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class TreeDigitsTest {
	
	private TreeDigits treeDigits = new TreeDigits();
	
	@Test
	public void testCase() {
		Assert.assertEquals("should be equals", "935",treeDigits.resolveArithmetic(5));
		Assert.assertEquals("should be equals", "027",treeDigits.resolveArithmetic(2));
	}
	
	@Test
	public void shouldAddZerosOnLeft() {
		String expected = "027";
		String result = treeDigits.format(27);

		Assert.assertEquals("should be equals",expected, result);
	}
	
	@Test
	public void shouldReverseNumber() {
		int expected = 345;
		int result = treeDigits.reverseNumber(543);
		
		Assert.assertEquals("should be equals", expected, result);
	}
	
	@Test
	public void shouldExtract3NumberBeforeLastOne() {
		int expected = 354;
		int result = treeDigits.extractTreeNumbers(BigInteger.valueOf(45553546));
		
		Assert.assertEquals("should be equals", expected, result);
	}
	
	

}
