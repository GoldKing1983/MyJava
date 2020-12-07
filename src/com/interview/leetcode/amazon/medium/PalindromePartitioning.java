package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;
/*

https://leetcode.com/problems/palindrome-partitioning/
Similar to https://leetcode.com/problems/factor-combinations

Current Permutation Index is: 0 1 Current Combo:[a]
Current Permutation Index is: 1 2 Current Combo:[a, a]
Current Permutation Index is: 2 3 Current Combo:[a, a, b]
Current Permutation Index is: 3 4 Current Combo:[a, a, b, a]
Current Permutation Index is: 4 5 Current Combo:[a, a, b, a, a]
Result Found:[[a, a, b, a, a]]
BackTracking to Index : 4 BackTracking Combo is:[a, a, b, a]
BackTracking to Index : 3 BackTracking Combo is:[a, a, b]
Current Permutation Index is: 3 5 Current Combo:[a, a, b, aa]
Result Found:[[a, a, b, a, a], [a, a, b, aa]]
BackTracking to Index : 4 BackTracking Combo is:[a, a, b]
BackTracking to Index : 2 BackTracking Combo is:[a, a]
BackTracking to Index : 1 BackTracking Combo is:[a]
Current Permutation Index is: 1 4 Current Combo:[a, aba]
Current Permutation Index is: 4 5 Current Combo:[a, aba, a]
Result Found:[[a, a, b, a, a], [a, a, b, aa], [a, aba, a]]
BackTracking to Index : 4 BackTracking Combo is:[a, aba]
BackTracking to Index : 3 BackTracking Combo is:[a]
BackTracking to Index : 0 BackTracking Combo is:[]
Current Permutation Index is: 0 2 Current Combo:[aa]
Current Permutation Index is: 2 3 Current Combo:[aa, b]
Current Permutation Index is: 3 4 Current Combo:[aa, b, a]
Current Permutation Index is: 4 5 Current Combo:[aa, b, a, a]
Result Found:[[a, a, b, a, a], [a, a, b, aa], [a, aba, a], [aa, b, a, a]]
BackTracking to Index : 4 BackTracking Combo is:[aa, b, a]
BackTracking to Index : 3 BackTracking Combo is:[aa, b]
Current Permutation Index is: 3 5 Current Combo:[aa, b, aa]
Result Found:[[a, a, b, a, a], [a, a, b, aa], [a, aba, a], [aa, b, a, a], [aa, b, aa]]
BackTracking to Index : 4 BackTracking Combo is:[aa, b]
BackTracking to Index : 2 BackTracking Combo is:[aa]
BackTracking to Index : 1 BackTracking Combo is:[]
Current Permutation Index is: 0 5 Current Combo:[aabaa]
Result Found:[[a, a, b, a, a], [a, a, b, aa], [a, aba, a], [aa, b, a, a], [aa, b, aa], [aabaa]]
BackTracking to Index : 4 BackTracking Combo is:[]


 */
public class PalindromePartitioning {
  List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    recur(s, 0, new ArrayList<>());
    return res;
  }

  private void recur(String s, int start, List<String> ls) {
    if (start == s.length()) {
      res.add(new ArrayList<>(ls));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (isP(s, start, i)) {
        ls.add(s.substring(start, i + 1));
        recur(s, i + 1, ls);
        ls.remove(ls.size() - 1);
      }
    }
  }

  private boolean isP(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }
}
