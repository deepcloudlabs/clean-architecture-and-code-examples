package com.example.utils;

import java.util.function.IntPredicate;

public interface NumberUtils {
	IntPredicate even = i -> i % 2 == 0; // (1)

	static boolean isEven(int i) { // (2)
		return i%2 == 0;
	}
}
