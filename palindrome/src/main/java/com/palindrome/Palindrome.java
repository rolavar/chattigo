package com.palindrome;

import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

	private final static int MAX_NUMBER = 1000000;
	private final static int MIN_NUMBER = 1;

	public static void main(String[] args) throws IOException {
		Palindrome palindrome = new Palindrome();
		Scanner sc = new Scanner(System.in);
		try {
			int number = sc.nextInt();
			if (MAX_NUMBER < number || MIN_NUMBER > number) {
				throw new IllegalArgumentException(String.format("Number must be between %d and %d", 1, 1000000));
			}
			System.out.println(palindrome.nextPrimePalindrome(number));
		} finally {
			sc.close();
		}

	}
	
	public int nextPrimePalindrome(int number) {
		while (true) {
			if (isPalindrome(number) && isPrime(number)) {
				return number;
			} else {
				number++;
			}
		}

	}

	public boolean isPalindrome(int number) {
		int temp = number;
		int aux = 0;

		while (temp != 0) {
			aux = aux * 10 + temp % 10;
			temp /= 10;
		}

		return aux == number;

	}

	public boolean isPrime(int number) {
		if (number <= 1) {
			return Boolean.FALSE;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}

}
