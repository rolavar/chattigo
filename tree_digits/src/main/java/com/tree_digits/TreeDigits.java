package com.tree_digits;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class TreeDigits {

	public static void main(String[] args) {
		TreeDigits treeDigits = new TreeDigits();
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(treeDigits.resolveArithmetic(number));
		sc.close();
	}

	public String resolveArithmetic(int n) {
		BigDecimal sqrt = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL32).add(BigDecimal.valueOf(3));
		return format(extractTreeNumbers(
				BigDecimal.valueOf(Math.pow(sqrt.doubleValue(), n)).setScale(1, RoundingMode.HALF_UP).unscaledValue()));
	}

	public int extractTreeNumbers(BigInteger number) {
		int value = 0;
		number = number.divide(BigInteger.TEN);
		int n = 0;
		while (n++ < 3) {
			value = value * 10 + number.remainder(BigInteger.TEN).intValue();
			number = number.divide(BigInteger.TEN);
		}

		return reverseNumber(value);

	}

	public int reverseNumber(int number) {
		int reversed = 0;
		while (number != 0) {
			reversed = reversed * 10 + number % 10;
			number /= 10;
		}
		return reversed;
	}

	public String format(int number) {
		return String.format("%03d", number);
	}

}
