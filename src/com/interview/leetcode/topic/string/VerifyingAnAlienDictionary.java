package com.interview.leetcode.topic.string;

/*
 https://leetcode.com/problems/verifying-an-alien-dictionary/

Using array and indexof instead of map... 
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
