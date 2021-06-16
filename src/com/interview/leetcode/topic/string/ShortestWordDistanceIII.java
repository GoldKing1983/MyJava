package com.interview.leetcode.topic.string;

/*

https://leetcode.com/problems/shortest-word-distance-iii/

1) else code is same as ShortestWordDistance
2) if word1 and word2 are same. Alternatively set index on word1Index and word1Index.

Ex: 
Input: wordsDict = ["practice", "makes", "perfect", "makes", "makes"], word1 = "makes", word2 = "makes"
Output: 1
 
word1Index =2
word1Index =4

Now calculate distance

Then...

word1Index =3
word1Index =4
 
Now calculate distance

 */
public class ShortestWordDistanceIII {
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int i = 0, word1Index = -1, word2Index = -1;
    int shortestWordDistance = Integer.MAX_VALUE;

    int counter = 0;
    if (word1.equals(word2)) {
      for (String word : wordsDict) {
        if (word.equals(word1)) {
          if (counter % 2 == 0) {
            word1Index = i;
            counter++;
          } else {
            word2Index = i;
            counter++;
          }
        }

        if (word1Index != -1 && word2Index != -1) {
          int currentWordDistance = Math.abs(word1Index - word2Index);
          shortestWordDistance = Math.min(currentWordDistance, shortestWordDistance);
        }
        i++;
      }

    } else {
      for (String word : wordsDict) {
        if (word.equals(word1)) word1Index = i;
        else if (word.equals(word2)) word2Index = i;

        if (word1Index != -1 && word2Index != -1) {
          int currentWordDistance = Math.abs(word1Index - word2Index);
          shortestWordDistance = Math.min(currentWordDistance, shortestWordDistance);
        }
        i++;
      }

    }

    return shortestWordDistance;

  }
}
