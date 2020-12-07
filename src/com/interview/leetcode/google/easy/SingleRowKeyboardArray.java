package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/single-row-keyboard/
====================================================Requirement==================================================================
1) There is a special keyboard with all keys in a single row.
2) initially your finger is at index 0. 
3) To type a character, you have to move your finger to the index of the desired character. 
4)You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
======================================================Example1===================================================================
Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
a(Initial Finger Location) to c --> 2
c to b --> 1
b to a --> 1
Output: 4 (2 + 1 + 1 = 4)
======================================================Example2===================================================================
Input: keyboard = "bcdefghijklmnopqrstuvwxyza", word = "cba"
b(Initial Finger Location) to c --> 1
c to b --> 1
b to a --> 25
Output: 27 (1 + 1 + 25 = 27)
==================================================Initial Thinking===============================================================
Note: Keyboard characters can rotated/shuffled. But there will be 26 characters all time.
If keyboard is only rotated. Then we don't need map. Just startIndex of keyboard character is enough. See Also AlphabetBoardPath
===================================================Solution approach=============================================================
Ex: keyboard = "bdz" 
             "a b c d e f g h i j k l m n o p r s t u v w x y z
    bucket = "0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 =====> This is important,understanding this makes solving problem
    word = "dbz"
    
 */
public class SingleRowKeyboardArray {
  public int calculateTime(String keyboard, String word) {
    // fill mapping for the keyboard chars and indexes
    int[] bucket = new int[26];
    int prevIndex = 0;
    for (char ch : keyboard.toCharArray()) {
      int charIndex = ch - 'a'; // Ex: a=0, b=1, c=2, d=3....
      bucket[charIndex] = prevIndex++; // keyboard = "cab"... then map[2=0, 0=1, 1=2]
    }

    int distance = 0;
    prevIndex = 0; // Logically it can be 0. map[keyboard.charAt(0) - 'a'];
    for (char ch : word.toCharArray()) {
      int charIndex = ch - 'a'; // Ex: a=0, b=1, c=2, d=3....
      int currIndex = bucket[charIndex]; // word = "cab"... then map[0=2, 1=3,

      distance += Math.abs(currIndex - prevIndex); // add difference to the result

      prevIndex = currIndex; // save current as previous position for the next iteration
    }
    return distance;
  }
}
