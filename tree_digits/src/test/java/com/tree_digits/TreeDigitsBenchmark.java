package com.tree_digits;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class TreeDigitsBenchmark {

	private final static int MAX_LOOP = 1000000;

	@Test
	public void init() throws RunnerException {
		Options options = new OptionsBuilder().include(this.getClass().getName() + ".*").mode(Mode.AverageTime)
				.warmupTime(TimeValue.seconds(1)).warmupIterations(1).threads(1).measurementIterations(1).forks(1)
				.shouldFailOnError(true).shouldDoGC(true).timeout(TimeValue.seconds(60)).build();

		new Runner(options).run();
	}

	@Benchmark
	public void resolveArithmetic(Blackhole bh) {
		int n = 0;
		BigDecimal sqrt = BigDecimal.ZERO;
		try {
			while (n++ < 1000) {
				sqrt = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL32).add(BigDecimal.valueOf(3));
				Double powResult = Math.pow(sqrt.doubleValue(), n);
				if (Double.isInfinite(powResult)) {
					bh.consume(sqrt.pow(n).setScale(1, RoundingMode.HALF_UP).unscaledValue().longValue());
				}else {
					bh.consume(BigDecimal.valueOf(powResult).setScale(1, RoundingMode.HALF_UP).unscaledValue().longValue());
				}
			}
		}catch(Exception ex) {
			System.out.println(n);
		}
		

	}

	@Benchmark
	public void resolveArithmeticStr(Blackhole bh) {
		BigDecimal sqrt = BigDecimal.ZERO;
		int n = 0;
		String result = "";
		while (n++ < 1000) {
			sqrt = BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128).add(BigDecimal.valueOf(3));
			Double powResult = Math.pow(sqrt.doubleValue(), n);
			if (Double.isInfinite(powResult)) {
				result = sqrt.pow(n).setScale(1, RoundingMode.HALF_UP).unscaledValue().toString();
			}else {
				result = BigDecimal.valueOf(powResult).setScale(1, RoundingMode.HALF_UP).unscaledValue().toString();
			}
			
			result = result.substring(0, result.length() - 1);
			if (result.length() < 3) {
				bh.consume(format(Integer.parseInt(result)));
				continue;
			}

			bh.consume(result.substring(result.length() - 3));

		}

	}

	@Benchmark
	public void extractTreeNumbers(Blackhole bh) {

		int n = 0, n2 = 0, value = 0;
		BigInteger number = BigInteger.ONE;
		number = number.divide(BigInteger.TEN);
		while (n++ < MAX_LOOP) {
			number = BigInteger.valueOf(n);
			while (n2++ < 3) {
				value = value * 10 + number.remainder(BigInteger.TEN).intValue();
				number = number.divide(BigInteger.TEN);
			}

			bh.consume(value);
		}

	}

	@Benchmark
	public void reverseNumber(Blackhole bh) {
		int n = 0, reversed = 0;
		int number;
		while (n++ < MAX_LOOP) {
			number = n;
			while (number != 0) {
				reversed = reversed * 10 + number % 10;
				number /= 10;
			}
			bh.consume(reversed);
		}

	}

	public String format(int number) {
		return String.format("%03d", number);
	}
}
