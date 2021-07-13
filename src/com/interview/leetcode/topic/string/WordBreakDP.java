package com.interview.leetcode.topic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/description/
Almost Same as LongestIncreasingSubSequenceDP .. See image WordBreakDP.png

When a match happens, in WordBreakQueue we put the suffixString in queue, here we set dp[j] to true. that is the only
difference.

In WordBreakQueue we fetch values from queue, here which ever index is true, we pick the following substring
=====================================================Time Complexity=============================================================
O(n^3). Note: "not exponential".
=======================================================Data Flow Analysis========================================================
Oth character represents empty which is set as true as part of initialization. 

1) For 2 char
        l r  
   Pick 0 1 2 Step1
        l   r 
   Pick 0 1 2 Step2
          l r 
   Pick 0 1 2 Step3
===========
Ex: [a b] s=ab
Visualization = ["" a b]... Adding empty as initial prefix True.

outer loop run 1 time.. inner loop run 2 time..
initially dp= [T F F]

isPrefixTrue = true
suffixString = 'a'
After Step1 dp= [T T F]

isPrefixTrue = true
suffixString = 'ab'
After Step2 dp= [T T F]

isPrefixTrue = true
suffixString = 'b'
After Step2 dp= [T T T]
===========
Ex: [a ab] s=ab

outer loop run 1 time.. inner loop run 1 time..
initially dp= [T F F]

isPrefixTrue = true
suffixString = 'a'
After Step1 dp= [T T F]

isPrefixTrue = true
suffixString = 'ab'
After Step2 dp= [T T T]

Step3 will not run
=================================================================================================================================
 *
 */
public class WordBreakDP {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);

    boolean[] dp = new boolean[s.length() + 1];

    dp[0] = true; // Initially we set prefixString for "" as true. 
    for (int left = 1; left <= s.length(); left++) {
      for (int right = 0; right < left; right++) {
        boolean isPrefixTrue = dp[right];
        String suffixString = s.substring(right, left);
        boolean isSuffixTrue = wordDictSet.contains(suffixString);
        if (isPrefixTrue && isSuffixTrue) {
          dp[left] = true; // set dp space from prefixToSuffix as true.
          break;
        }
      }
    }
    return dp[s.length()];
  }
}
