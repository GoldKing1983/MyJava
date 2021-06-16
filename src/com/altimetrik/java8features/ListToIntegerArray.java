package com.altimetrik.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToIntegerArray {
  public static void main(String[] args) {
    List<Integer> result = new ArrayList<>();
    result.add(10);
    result.add(20);

    int[] resultArray = result.stream().mapToInt(i -> i).toArray();

    System.out.println(Arrays.toString(resultArray));
  }
}
