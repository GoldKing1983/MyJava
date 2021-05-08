package com.interview.leetcode.topic.string;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
===========================================================Requirement===========================================================
1) Given a array of strings.
2) Return unique concatenation of sub-sequence.

============================================================Example1=============================================================
Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "",

                                            "un",
                                            "uniq"
                                            "unue"--> This is not unique. So cannot have this
                                            
                                            "iq",
                                            "ique".
                                            
                                            "ue"
Maximum length is 4.

============================================================Example2=============================================================
Input: arr = ["un","iqq","uee"]
Output: 2
Explanation: Only "un" is unique. So we can ignore all  
========================================================Solution Approach========================================================
1) Straight forward logic... No connection to subsets/combinations/permutations
2) Take a currentString join with all sub-sequent result string.
3) if the currentString or newCombinationString is not unique ignore.
4) Cache the max of resultSize. 


 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
  // This method simply checks duplicate character. Set would have been better understanding.
  private boolean isUnique(String str) {
    if (str.length() > 26) return false;
    boolean[] used = new boolean[26];
    char[] arr = str.toCharArray();
    for (char ch : arr) {
      if (used[ch - 'a']) {
        return false;
      } else {
        used[ch - 'a'] = true;
      }
    }
    return true;
  }

  public int maxLength(List<String> arr) {
    int maxLength = 0;
    List<String> result = new ArrayList<>();
    result.add("");
    for (String str : arr) {
      if (!isUnique(str)) continue;

      //We can avoid newResult by adding directly to result by managing index. But this is better
      List<String> newResult = new ArrayList<>();
      for (String candidate : result) {
        String temp = candidate + str;
        if (isUnique(temp)) {
          newResult.add(temp);
          maxLength = Math.max(maxLength, temp.length());
        }

      }
      result.addAll(newResult);

    }

    return maxLength;
  }
}
