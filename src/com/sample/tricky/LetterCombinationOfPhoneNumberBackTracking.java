package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Ex: "23"
                        "empty"
                /         |        \
              a           b         c
            / | \       / | \     / | \
           ad ae af    bd be bf  cd ce cf
              
 */
public class LetterCombinationOfPhoneNumberBackTracking {

  private static final String[] LETTERS =
      {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) return Arrays.asList();
    return permute(digits, new StringBuilder(), new ArrayList<>(), 0, digits.length());
  }

  private List<String> permute(String digits, StringBuilder currentResult, List<String> result,
      int currentIndex, int n) {
    if (currentIndex == n) {
      result.add(currentResult.toString());
      return result;
    }
    String word = LETTERS[digits.charAt(currentIndex) - '0'];
    //String currentWord = LETTERS[Integer.parseInt(digits.charAt(currentIndex)+"")];
    for (char c : word.toCharArray()) {
      currentResult.append(c);
      permute(digits, currentResult, result, currentIndex + 1, n);
      currentResult.deleteCharAt(currentResult.length() - 1);
    }
    return result;
  }
}
