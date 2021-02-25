package com.interview.leetcode.topic.string;

/*

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.



Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true


 */
public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] words1, String[] words2) {
        int i = 0, j = 0;
        int n1 = words1.length, n2=words2.length;
        int word1I = 0, word2I = 0;
        while(i != n1 && j != n2) {
            String word1 = words1[i];
            int word1N = word1.length();

            String word2 = words2[j];
            int word2N = word2.length();

            boolean maxReached = false;
            while(true) {
                if(word1I == word1N) {
                    i++;
                    word1I = 0;
                    maxReached = true;
                }
                if (word2I == word2N) {
                    j++;
                    word2I = 0;
                    maxReached = true;
                }
                if(maxReached) break;

                char c1 = word1.charAt(word1I);
                char c2 = word2.charAt(word2I);
                if(c1!=c2) return false;
                word1I++;
                word2I++;

            }

        }

        return i==n1 && j==n2;
    }
}
