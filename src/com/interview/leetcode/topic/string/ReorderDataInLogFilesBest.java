package com.interview.leetcode.topic.string;

import java.util.Arrays;

/*
https://leetcode.com/problems/reorder-data-in-log-files/
============================================================Requirement==========================================================
0) You have an array of logs.  Each log is a space delimited string of words.
    ex:[hello 123] [hello hello] [world hello] [test 567]
1) Split each word by "first" space(" "). Lets say key or identifier is leftValue and value is rightValue.
2) rightValue is either digit(digitLog) or letter(letterLog) - decided based on first character of rightValue
3) Re-order input such that,
3a) letterLog comes first.
3b) if 2 letterLog is same, then sort by identifier or key.
3c) the digitLog should come later letterLog, in the same order as input order.


Return the final order of the logs.
===============================================================Example1==========================================================
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


See also TopKFrequentWords
 */
public class ReorderDataInLogFilesBest {
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (final String s1, final String s2) -> {
      // indexOf API goes from leftToRight and return firstIndexOf
      int string1SplitIndexPos = s1.indexOf(' ');
      int string2SplitIndexPos = s2.indexOf(' ');

      char string1FirstCharAfterSplit = s1.charAt(string1SplitIndexPos + 1);
      char string2FirstCharAfterSplit = s2.charAt(string2SplitIndexPos + 1);

      boolean isString1RightValueIsAlpha = Character.isLetter(string1FirstCharAfterSplit);
      boolean isString2RightValueIsAlpha = Character.isLetter(string2FirstCharAfterSplit);
      String string1LeftKey = s1.substring(0, string1SplitIndexPos);
      String string1RightValue = s1.substring(string1SplitIndexPos + 1);

      String string2LeftKey = s2.substring(0, string2SplitIndexPos);
      String string2RightValue = s2.substring(string2SplitIndexPos + 1);

      if (isString1RightValueIsAlpha || isString2RightValueIsAlpha) {

        if (isString1RightValueIsAlpha && isString2RightValueIsAlpha) { // Case : Both String1 and String2 are alpha
          if (string1RightValue.equals(string2RightValue)) { // Ex: "abc hello" "bcd hello". Return by their keys
            return string1LeftKey.compareTo(string2LeftKey);
          }
          return string1RightValue.compareTo(string2RightValue); // Ex: "abc test" "bcd hello". Return by their values
        }
        // Below is like return descending order. 
        // Because in ASCII table, '0-9' comes first and then 'a-z'... i.e 'a-z' is bigger than '0-9'
        // If anyone is alphabet, we want alphabet to come first like bigToComeFirst. So do descending order.
        return string2RightValue.compareTo(string1RightValue);

      } else {
        return 0; // Both String1 and String2 are digits. Maintain the same order.
      }
    });

    return logs;
  }
}
