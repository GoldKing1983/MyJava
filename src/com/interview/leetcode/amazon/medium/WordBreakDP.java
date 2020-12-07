package com.interview.leetcode.amazon.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *
 */

/*
Input: s = "bb", wordDict = ["a","b","bbb","bbbb"]
Expected: true

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Input: s = "cars", wordDict = ["car","ca","rs"]
Output: true

Input: s = "cars", wordDict = ["ca","cars"]
Output: true

dp 0th index is set as true. for String[0], dp[1] will be true.

"cars"
["ca","cars"]
c [true, false, false, false, false]
ca [true, false, true, false, false]
car [true, false, true, false, false]
cars [true, false, true, false, true]
r [true, false, true, false, true]
rs [true, false, true, false, true]
==============================================================================
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

c [true, false, false, false, false, false, false, false, false, false]
ca [true, false, false, false, false, false, false, false, false, false]
cat [true, false, false, true, false, false, false, false, false, false]
cats [true, false, false, true, true, false, false, false, false, false]
catsa [true, false, false, true, true, false, false, false, false, false]
catsan [true, false, false, true, true, false, false, false, false, false]
catsand [true, false, false, true, true, false, false, false, false, false]
catsando [true, false, false, true, true, false, false, false, false, false]
catsandog [true, false, false, true, true, false, false, false, false, false]
s [true, false, false, true, true, false, false, false, false, false]
sa [true, false, false, true, true, false, false, false, false, false]
san [true, false, false, true, true, false, false, false, false, false]
sand [true, false, false, true, true, false, false, true, false, false]
sando [true, false, false, true, true, false, false, true, false, false]
sandog [true, false, false, true, true, false, false, true, false, false]
a [true, false, false, true, true, false, false, true, false, false]
an [true, false, false, true, true, false, false, true, false, false]
and [true, false, false, true, true, false, false, true, false, false]
ando [true, false, false, true, true, false, false, true, false, false]
andog [true, false, false, true, true, false, false, true, false, false]
o [true, false, false, true, true, false, false, true, false, false]
og [true, false, false, true, true, false, false, true, false, false]
==============================================================================
 */
public class WordBreakDP {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dictionary = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 0; i < s.length(); i++) {
      if (dp[i]) {
        for (int j = i + 1; j <= s.length(); j++) {
          String sub = s.substring(i, j);
          if (dictionary.contains(sub)) {
            dp[j] = true;
          }
          // System.out.println(sub + " " + Arrays.toString(dp));
        }
      }
    }
    return dp[s.length()];
  }

}
