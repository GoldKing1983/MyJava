package com.interview.leetcode.topic.string;

import java.util.Set;
/*
https://leetcode.com/problems/reverse-vowels-of-a-string

in case of only 1 vowel in input. A swap will happen from right and left, in which case still output good.
Ex: cop... o swapped with o.
 */
public class ReverseVowelsOfAString {
  public String reverseVowels(String s) {
    char[] list = s.toCharArray();
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    int left = 0, right = list.length - 1;
    while (left < right) {
      if (!set.contains(list[left])) {
        left++;
        continue;
      }
      if (!set.contains(list[right])) {
        right--;
        continue;
      }
      char temp = list[left];
      list[left] = list[right];
      list[right] = temp;
      left++;
      right--;
    }
    return String.valueOf(list);
  }
}
