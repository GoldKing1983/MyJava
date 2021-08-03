package com.interview.leetcode.topic.string;

import java.util.HashMap;
import java.util.Map;

/*
 https://leetcode.com/problems/verifying-an-alien-dictionary/
===========================================================Requirement===========================================================
1) If there are 2 word in input. Compare word1 and word2.... for 3 words. compare word1&word2, then word2&word3....
2) On comparing 2 word characters, 2 cases can arrive. 
   case1) If word1 first character     equals word2 first character. Then compare continues for next char in word1 and word2
   case2) If word1 first character not equals word2 first character. 
      case2a) If word1 first character greater than word2 first character. return false
      case2b) If word1 first character less than word2 first character. We can move on comparing 2nd and 3rd word.
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
This code is scalable. Because we can add even more Characters to map.
1) Save the order or each character to map.
2) ex: order: "cab". Then bucket=[c=0][a=1][b=2]
3) Then compare words and do the straight forward logic
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
public class VerifyingAnAlienDictionaryBetterScalable {

  public boolean isAlienSorted(String[] words, String order) {

    Map<Character, Integer> bucket = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      bucket.put(order.charAt(i), i);
    }

    for (int i = 1; i < words.length; i++) {
      String previousWord = words[i - 1];
      String currentWord = words[i];

      for (int j = 0; j < previousWord.length(); j++) {
        int previousWordCharPosition = bucket.get(previousWord.charAt(j));

        if (j == currentWord.length()) return false;// Ex: [ab][a]"a-z"...false... Ex: [a][ab]"a-z"...true
        int currentWordCharPosition = bucket.get(currentWord.charAt(j));

        if (previousWordCharPosition == currentWordCharPosition) continue;

        /*
         * If there is a difference, only one character we need to check between 2 words. Result can be success or failure.
         */
        if (previousWordCharPosition > currentWordCharPosition) return false;

        break; // if (previousWordCharPosition < currentWordCharPosition). no need to add this condition. Because this is a last leftout condition. 
      }
    }
    return true;
  }
}
