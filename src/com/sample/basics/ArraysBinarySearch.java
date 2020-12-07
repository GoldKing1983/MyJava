package com.sample.basics;

import java.util.Arrays;

/*
========================================Arrays.binarySearch returns=================================================
1) if searchKey found, returns index of the search key,
2) otherwise, negative value.... (i.e) (-(insertion point) - 1).

Ex: [5,10,15] -> searchKey: 5  ==> returns 0
Ex: [5,10,15] -> searchKey: 10 ==> returns 1
Ex: [5,10,15] -> searchKey: 4  ==> returns -1
Ex: [5,10,15] -> searchKey: 6  ==> returns -2
Ex: [5,10,15] -> searchKey: 14 ==> returns -3
Ex: [5,10,15] -> searchKey: 16 ==> returns -4

3) The "negative return value" is nice trick to identify simply an element is found or not in binary search.
Also this is a clear approach to send back "insertion point" of an element which is not found in input.
======================================================================================================================
 */
public class ArraysBinarySearch {
  public static void main(String[] args) {
    int[] input = {5, 10, 15};
    System.out.println(Arrays.binarySearch(input, 5));
    System.out.println(Arrays.binarySearch(input, 15));
    System.out.println(Arrays.binarySearch(input, 14));
    System.out.println(Arrays.binarySearch(input, 16));
  }
}
