package com.interview.leetcode.topic.string;

/*
 https://leetcode.com/problems/verifying-an-alien-dictionary/
===========================================================Requirement===========================================================
1) If there are 2 word in input. Compare word1 and word2.... for 3 words. compare word1&word2, then word2&word3....
2) On comparing 2 word characters, 3 cases can arrive. 
      case1) If word1 first character equals       word2 first character. Then compare continues for next char in word1 and word2
      case2) If word1 first character greater than word2 first character. return false
      case3) If word1 first character less    than word2 first character. We can move on comparing 2nd and 3rd word.
  
============================================================Example1=============================================================
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
============================================================Example2=============================================================
Input: words = ["app","apple","banana"], order = "abcdefghijklmnopqrstuvwxyz"
Output: true
============================================================Example3=============================================================
Input: words = ["banana","app","apple"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
========================================================Solution Approach========================================================
=========Corner Case============Assume firstWord or previousWord is master always============
   1) If word1 and word2 are equal to certain index and word2 is finished then return false.
   Note: this doesn't mean word2 size should be greater than or equal to word1.
   Ex: (Consider a-z dictionary)
   "app" "apple" ==> true
   "apple" "app" ==> false... because till app both same, then nothing to match in word2
   "a" "" ==> false
   "" "a" ==> true
   "apple" "apq" ==> true
   "apple" "aq" ==> true

*/
public class VerifyingAnAlienDictionary {

  public boolean isAlienSortedWithoutIndexOf(String[] words, String order) {

    /*
     *    h(index7)=1 l(index10)=2
     *     0 1 2 3 4 5 6 7 8 9 10
          [0 0 0 0 0 0 0 1 0 0 2 ]
     */
    int[] bucket = new int[26];
    for (int i = 0; i < 26; i++) {
      int index = order.charAt(i) - 'a'; //h=7
      bucket[index] = i;
    }

    for (int i = 1; i < words.length; i++) {
      String previousWord = words[i - 1]; // previousWord is the master
      String currentWord = words[i];

      // previousWord is the master. So we end loop by previousWord. Ex: "" "a" ==> true
      for (int j = 0; j < previousWord.length(); j++) {
        int previousWordCharPosition = bucket[previousWord.charAt(j) - 'a'];

        if (j == currentWord.length()) return false;// Ex: [ab][a]"a-z"...false... Ex: [a][ab]"a-z"...true

        int currentWordCharPosition = bucket[currentWord.charAt(j) - 'a'];

        if (previousWordCharPosition == currentWordCharPosition) continue;

        /*
         * If there is a difference, only one character we need to check between 2 words. Result can be success or failure.
         */
        if (previousWordCharPosition > currentWordCharPosition) return false;

        if (previousWordCharPosition < currentWordCharPosition) break;
      }
    }
    return true;
  }

  // Below is not recommended as indexOf takes O(n) times for each word.
  public boolean isAlienSortedAvoidMap(String[] words, String order) {
    for (int i = 1; i < words.length; i++) {
      String previousWord = words[i - 1];
      String currentWord = words[i];

      for (int j = 0; j < previousWord.length(); j++) {
        int previousWordCharPosition = order.indexOf(previousWord.charAt(j));

        if (j == currentWord.length()) return false;// Ex: [ab][a]"a-z"...false... Ex: [a][ab]"a-z"...true
        int currentWordCharPosition = order.indexOf(currentWord.charAt(j));

        if (previousWordCharPosition == currentWordCharPosition) continue;

        /*
         * If there is a difference, only one character we need to check between 2 words. Result can be success or failure.
         */
        if (previousWordCharPosition > currentWordCharPosition) return false;
        if (previousWordCharPosition < currentWordCharPosition) break;
      }
    }
    return true;
  }


}
