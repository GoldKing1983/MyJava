package com.interview.leetcode.facebook.easy;

/*
 https://leetcode.com/problems/verifying-an-alien-dictionary/
===========================================================Requirement===========================================================
1) If there are 2 word in input. Compare word1 and word2.... for 3 words. compare word1&word2, then word2&word3....
2) On comparing 2 word characters, 3 cases can arrive. 
      case1) If word1 first character equals       word2 first character. Then compare continues for next char in word1 and word2
      case2) If word1 first character greater than word2 first character. return false
      case3) If word1 first character less    than word2 first character. We can move on comparing 2nd and 3rd word.
  

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

========================================================Solution Approach========================================================
=========Corner Case============
   1) If word1 and word2 are equal to certain index and word2 is finished then return false.
   Note: this doesn't mean word2 size should be greater than or equal to word1.
   Ex: (Consider a-z dictionary)
   "app" "apple" ==> true
   "apple" "app" ==> false... because till app both same, then nothing to match in word2
   "apple" "apq" ==> true
   "apple" "aq" ==> true
   "a" "" ==> false

*/
public class VerifyingAnAlienDictionary {

  public boolean isAlienSortedAvoidMap(String[] words, String order) {
    for (int i = 1; i < words.length; i++) {
      String previousWord = words[i - 1];
      String currentWord = words[i];
      for (int j = 0; j < previousWord.length(); j++) {
        int previousWordCharPosition = order.indexOf(previousWord.charAt(j));
        if (j == currentWord.length()) return false;
        int currentWordCharPosition = order.indexOf(currentWord.charAt(j));
        if (previousWordCharPosition > currentWordCharPosition) return false;
        // If there is a difference, only one character we need to check between 2 words, so break.
        if (previousWordCharPosition < currentWordCharPosition) break;
      }
    }
    return true;
  }

  public boolean isAlienSortedWithoutIndexOf(String[] words, String order) {

    // h =0... l =1
    int[] bucket = new int[26];
    for (int i = 0; i < 26; i++) {
      int index = order.charAt(i) - 'a'; //h=8
      bucket[index] = i;
    }

    for (int i = 1; i < words.length; i++) {
      String previousWord = words[i - 1];
      String currentWord = words[i];

      for (int j = 0; j < previousWord.length(); j++) {
        int previousWordCharPosition = bucket[previousWord.charAt(j) - 'a'];
        if (j == currentWord.length()) return false;
        int currentWordCharPosition = bucket[currentWord.charAt(j) - 'a'];
        if (previousWordCharPosition > currentWordCharPosition) return false;
        // If there is a difference, only one character we need to check between 2 words, so break.
        if (previousWordCharPosition < currentWordCharPosition) break;
      }
    }
    return true;
  }
}
