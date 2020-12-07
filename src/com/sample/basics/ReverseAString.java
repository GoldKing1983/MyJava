package com.sample.basics;

/*
https://leetcode.com/problems/reverse-string/
	/*
	 * 1) Convert String to Character Array
	 * 2) Swap 1st and n th character, then
	 * 3) 2nd and n-1 character... So half traversal is enough
	 *
	 * Note: This saves a lot of object creation in memory. instead of using string concat operation with stringbuilder
	 */
public class ReverseAString {

  public static String reverse(String s) {
    char[] array = s.toCharArray();
    int left = 0, right = array.length - 1;
    while (left < right) {
      char tmp = array[left];
      array[left++] = array[right];
      array[right--] = tmp;
    }
    return new String(array);
  }
}
