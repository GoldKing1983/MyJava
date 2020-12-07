package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/generalized-abbreviation/

Similar to internationalization abbreviated as i18n. Find all combos.

input: "ha"
Ouptut: ["2","1a","h1","ha"]

To understand the requirement, see picture "GeneralizedAbbreviation.JPG"

Total combination is 2^n. So this solution is best solution.
Changing String to StringBuilder and Char array would improve performance to 100%.

====================================Solution Approach - Time Complexity - O(2^n)====================================
1) For every character, we can keep it or abbreviate it.
2) To keep it, we add it to the current solution and carry on dfs.
3) To abbreviate it, we omit it in the current solution, but increment the count,
which indicates how many characters have we abbreviated.
4) When we reach the end or need to put a character in the current solution,
and count is bigger than zero, we add the number into the solution.
=====================================================================================================================
 */
public class GeneralizedAbbreviation {
  public List<String> generateAbbreviations(String word) {
    List<String> ret = new ArrayList<>();
    dfs(ret, word, 0, "", 0);

    return ret;
  }

  private void dfs(List<String> ret, String word, int pos, String cur, int count) {
    if (pos == word.length()) {
      if (count > 0) cur += count;
      ret.add(cur);
    } else {
      dfs(ret, word, pos + 1, cur, count + 1);
      dfs(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
    }
  }
}
