package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Ex: "23"
a
ad
ae
af
b
bd
be
bf
c
cd
ce
cf


 */
public class LetterCombinationOfPhoneNumberDFS {

  private static final String[] LETTERS =
      {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) return Arrays.asList();
    return permute(digits, new StringBuilder(), new ArrayList<>(), 0, digits.length());
  }

  private List<String> permute(String digits, StringBuilder result, List<String> results, int index,
      int n) {
    if (index == n) {
      results.add(result.toString());
      return results;
    }
    String word = LETTERS[digits.charAt(index) - '0'];
    for (char c : word.toCharArray()) {
      result.append(c);
      permute(digits, result, results, index + 1, n);
      result.deleteCharAt(result.length() - 1);
    }
    return results;
  }
}
