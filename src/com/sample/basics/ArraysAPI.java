package com.sample.basics;

import java.util.Arrays;

public class ArraysAPI {
	public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4};
    Arrays.stream(arr).sum();
    Arrays.stream(arr).parallel().sum();
  }
}
