package com.interview.leetcode.topic.set;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/palindrome-permutation/

 Given a string, determine if re-arranging characters of the string could form a palindrome.

Solution is simple:
1) For even number of character....To be a palindrome, every character should occur even. Set size will be 0.
2) For odd number of character....To be a palindrome, every character should occur even and one character can occur once.
So set size will be 1.


For example:
"code" -> False,
"aab" -> True,
"carerac" -> True. (ccaarre)
 */

public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1; // For Odd character palindrome
    }

    /*
    Ex: cccc --> count = 1 then 0 then 1 then 0.
    Ex: cccca --> count = 1 then 0 then 1 then 0 then 1.
     */
    public boolean canPermutePalindromeBetter(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}
