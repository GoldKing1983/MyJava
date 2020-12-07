package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/decode-ways/description/
*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26

Ex: 123                     
                                  Empty
                                 /     \
                                1       12
                               / \      /   
                              2   23   3
                             /
                            3        


1) Single character match - if it is 0 skip. Rest all allowed
2) Two character match (10 to 26) - 
    a) begins with 0 skip. So 00 to 09 skip. 
    2) Greater than 26 skip.
3) If there is a zero in the beginning, then result 0. Because 0 cannot be used with any next combination of digits.
4) 0 in the middle can("1201") or cannot(301) be used to get result count
4) For Empty String "". result is 0.

1201 --> [1,20,1] // only 1 result count. Because need to use all characters for decoding
0121 --> 0 count
301 --> 0 count
226 --> 3 count --> It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)

*/
public class DecodeWaysRecursion {

  private int recur(int index, String str, int n) {

    if (index == n) return 1;

    if (str.charAt(index) == '0') return 0;

    int left = recur(index + 1, str, n);

    boolean validRight =
        (index + 1 <= n - 1) && Integer.parseInt(str.substring(index, index + 2)) <= 26;

    int right = validRight ? recur(index + 2, str, n) : 0;

    return left + right;
  }

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    return recur(0, s, s.length());
  }
}
