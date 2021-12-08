package com.palindrome;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

	private Palindrome palindrome = new Palindrome();

	@Test
	public void shouldBePalindrome() {
		Assert.assertTrue("should be true", palindrome.isPalindrome(303));
	}

	@Test
	public void shouldNotBePalindrome() {
		Assert.assertFalse("shouldn't be true", palindrome.isPalindrome(3033));
	}

	@Test
	public void shouldBePrime() {
		Assert.assertTrue("should be true", palindrome.isPrime(509));
	}

	@Test
	public void shouldntBePrime() {				
		Assert.assertFalse("should be false", palindrome.isPrime(504));
	}

	@Test
	public void shouldReturnNextPrimePalindrome() {
		Assert.assertEquals(101, palindrome.nextPrimePalindrome(31));
		
		Assert.assertEquals(1003001, palindrome.nextPrimePalindrome(456789));
	} 	

}
