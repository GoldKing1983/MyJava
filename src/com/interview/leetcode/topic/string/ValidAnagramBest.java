package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an anagram of s.
Constraint : Input is only lowerCase alphabet.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

========================================================Solution Approach========================================================
1) Same as ValidAnagram
2) Iterate both String separately. 
3) In the second loop. If bucketIndexValue goes less than 0 return. So this avoids lot of comparism.
    Ex: intputString1="abc" intputString2="def"
    
    When parsing intputString2, i can returnFalse at index0 and don't need to traverse further. 

 */
public class ValidAnagramBest {

  public boolean isAnagram(String inputString1, String inputString2) {
    if (inputString1.length() != inputString2.length()) return false;
    int[] bucket = new int[26];
    for (char c : inputString1.toCharArray()) {
      int index = c - 'a';
      bucket[index]++;
    }

    for (char c : inputString2.toCharArray()) {
      int index = c - 'a';
      bucket[index]--;
      if (bucket[index] < 0) return false;
    }

    // less than compare already done in 2nd for loop. So only greater check is required.
    for (int b : bucket) {
      if (b != 0) return false;
    }
    return true;
  }
}
