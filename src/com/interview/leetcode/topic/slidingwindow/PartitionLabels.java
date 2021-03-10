package com.interview.leetcode.topic.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/partition-labels/
===========================================================Requirement===========================================================
1) Given a input characters
2) Partition consecutive characters into buckets, so that those characters are not
available in any of other buckets.
============================================================Example1=============================================================
input: abad -- window1 is aba and window2 is d.
output: 3,1

============================================================Example2=============================================================
input: ababd -- window1 is from abab and window2 is d
output: 4,1

========================================================Solution Approach========================================================
1) In first pass save the lastOccurrenceIndex of character from leftToRight.
2) In second pass from leftToRight 2 things are happening
   a) Mark maxOfWindowLength.
   b) If the currentCharacterIndex == maxOfWindowLength, then a partition of bucket is found.

=======================================================Data Flow Analysis========================================================
input: ababd
a b c d e f
2 3 0 4 0 0
===Parsing a at index0===
currentCharacterIndex=0, maxOfWindowLength = 2
maxOfWindowLength != currentCharacterIndex

===Parsing b at index1===
currentCharacterIndex=1, maxOfWindowLength = 3
maxOfWindowLength != currentCharacterIndex

===Parsing a at index0===
currentCharacterIndex=2, maxOfWindowLength = 3
maxOfWindowLength != currentCharacterIndex

===Parsing b at index0===
currentCharacterIndex=3, maxOfWindowLength = 3
maxOfWindowLength == currentCharacterIndex
Record the result

===Parsing b at index0===
currentCharacterIndex=4, maxOfWindowLength = 4
maxOfWindowLength == currentCharacterIndex
Record the result
=================================================================================================================================
 */
public class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    int[] cache = new int[26];
    int n = S.length();
    // save the lastOccurrenceIndex of character from leftToRight.
    for (int i = 0; i < n; i++) cache[S.charAt(i) - 'a'] = i;

    int maxOfWindowLength = 0, lastResultIndex = 0;
    List<Integer> result = new ArrayList<>();
    for (int currentCharacterIndex = 0; currentCharacterIndex < n; currentCharacterIndex++) {
      // Mark maxOfWindowLength.
      maxOfWindowLength = Math.max(maxOfWindowLength, cache[S.charAt(currentCharacterIndex) - 'a']);

      // currentCharacterIndex == maxOfWindowLength, then a partition of bucket is found
      if (currentCharacterIndex == maxOfWindowLength) {
        result.add(currentCharacterIndex - lastResultIndex + 1);
        lastResultIndex = currentCharacterIndex + 1;
        maxOfWindowLength = 0; // Reset maxOfWindowLength
      }
    }
    return result;
  }
}
