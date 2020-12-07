package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutation-sequence/
https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
https://www.educative.io/collection/page/5642554087309312/5679846214598656/140001
=====================================================Requirement===============================================================
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Input: n = 3, k = 3
Output: "213"
=====================================================Solution Approach===========================================================
1) A naive way of finding the kth permutation will be to find all permutations and then return the kth permutation.

Below approach Runtime Complexity is O(n).
1) Identify the block where the result exists.
2) Remove that block and continue step1. till empty.
=====================================================Data Flow Analysis===========================================================
Ex: n=4 and k=18... Answer="3421"

Save factorial and "n" numbers to refer and pick result
factorial[] = {1, 1, 2, 6, 24, ... n!}
numbers = {1, 2, 3, 4}
					================================Step1================================
The permutations of {1, 2, 3, 4} would be:

1 + (permutations of 2, 3, 4) = 6combos
2 + (permutations of 1, 3, 4) = 6combos
3 + (permutations of 1, 2, 4) = 6combos
4 + (permutations of 1, 2, 3) = 6combos

numbers = {1, 2, 3, 4}
factorial[] = {1, 1, 2, 6, 24, ... n!}

k=18(0 to 17) So =17... n=4 numbers[n-1] = 6 (So look in 3rd index of factorial. i.e 6)

17/6 = 3.
From numbers Pick index2. So current answer is 2.

k updated to (17-12)5... numbers = {1, 2, 4}
					================================Step2================================
Remaining permutations of {1, 2, 4} would be. Total Combination is 1*2*3 = 6.

1 + (permutations of 2, 4)
2 + (permutations of 1, 4)
4 + (permutations of 1, 2)

numbers = {1, 2, 4}
factorial[] = {1, 1, 2, 6, 24, ... n!}

k=5... n=3 numbers[n-1] = 2 (So look in 2nd index of factorial. i.e 2)

5/2 = 2.
From numbers Pick index2. So current answer is 4.
k updated to (5-4)1... numbers={1,2}

					================================Step3================================
Remaining permutations of {1, 2} would be. Total Combination is 1*2 = 6.

1 + (permutations of 2)

numbers = {1, 2}
factorial[] = {1, 1, 2, 6, 24, ... n!}

k=1... n=2 numbers[n-1] = 1 (So look in 1st index of factorial. i.e 1)

1/1 = 1.
From numbers Pick index1. So current answer is 2.
k updated to (1-1)0... numbers={1}

					================================Step4================================
last existing number 1 added directly

*/
public class PermutationSequenceOrFindKthPermutation {
  public String getPermutation(int n, int k) {
    List<Integer> numbers = new ArrayList<>();
    int[] factorial = new int[n + 1];
    StringBuilder sb = new StringBuilder();

    // create an array of factorial for lookup. factorial = {1, 1, 2, 6, 24, ... n!}
    factorial[0] = 1;
    for (int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i;

    // create a list of numbers to get output. numbers = {1, 2, 3, 4}
    for (int i = 1; i <= n; i++) numbers.add(i);

    k--;

    for (int i = 1; i < n; i++) {
      int index = k / factorial[n - i];
      sb.append(String.valueOf(numbers.get(index)));
      numbers.remove(index);
      k -= index * factorial[n - i];
    }
    sb.append(String.valueOf(numbers.get(0))); // If n=1... add it directly.
    return String.valueOf(sb);
  }
}
