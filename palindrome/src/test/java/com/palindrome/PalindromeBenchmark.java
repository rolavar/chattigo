package com.palindrome;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class PalindromeBenchmark {
	
	private final static int LOOP_START = 1000000;
	private final static int LOOP_END = 2000000;
	
	@Param(value = "1000000")
	private int n;

	
	@Test
	public void runBenchmarks() throws Exception{
		 Options options = new OptionsBuilder()
		            .include(this.getClass().getName() + ".*")
		            .mode(Mode.AverageTime)
		            .warmupTime(TimeValue.seconds(1))
		            .warmupIterations(1)
		            .threads(1)
		            .measurementIterations(1)
		            .forks(1)
		            .shouldFailOnError(true)
		            .shouldDoGC(true)
		            .build();

		    new Runner(options).run();
	}
	
	@Benchmark
	public static void isPalindrome(Blackhole bh) {
		int number, aux,x;
		for (x = LOOP_START; x < LOOP_END; x++) {
			aux = 0;
			number = x;
			while (number != 0) {
				aux = aux * 10 + number % 10;
				number /= 10;
			}
			bh.consume(aux == x);
		}

	}

	@Benchmark
	public static void isPalindrome2(Blackhole bh) {
		int number, x;
		int[] numbers;
		int n = 0;
		for (x = LOOP_START; x < LOOP_END; x++) {
			number = x;
			numbers = Arrays.stream(Integer.toString(number).split("")).mapToInt(Integer::parseInt).toArray();

			while (number != 0) {
				if (numbers[n++] != number % 10) {
					bh.consume(false);
				}
				number = number / 10;
			}
			n = 0;
			bh.consume(true);
		}

	}

	@Benchmark
	public static void isPrime(Blackhole bh) {
		int n,x;
		for (x = LOOP_START; x < LOOP_END; x++) {
			n = x;

			if (n <= 1) {
				bh.consume(false);
			}
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					bh.consume(false);

				}
			}
			bh.consume(true);

		}
	}
}
