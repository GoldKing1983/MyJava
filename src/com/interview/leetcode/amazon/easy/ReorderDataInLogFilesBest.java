package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;

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
    Arrays.sort(
        logs,
        (final String s1, final String s2) -> {
          // indexOf API goes from leftToRight and return firstIndexOf
          int string1SplitIndexPos = s1.indexOf(' ');
          int string2SplitIndexPos = s2.indexOf(' ');

          char string1FirstCharAfterSplit = s1.charAt(string1SplitIndexPos + 1);
          char string2FirstCharAfterSplit = s2.charAt(string2SplitIndexPos + 1);

          boolean isString1IsAlpha = Character.isLetter(string1FirstCharAfterSplit);
          boolean isString2IsAlpha = Character.isLetter(string2FirstCharAfterSplit);
          String string1Key = s1.substring(0, string1SplitIndexPos);
          String string1Value = s1.substring(string1SplitIndexPos + 1);

          String string2Key = s2.substring(0, string2SplitIndexPos);
          String string2Value = s2.substring(string2SplitIndexPos + 1);

          if (isString1IsAlpha && isString2IsAlpha) { // Case : Both String1 and String2 are alpha
            if (string1Value.equals(string2Value)) { // Ex: "abc hello" "bcd hello". Return by their keys
              return string1Key.compareTo(string2Key);
            }
            return string1Value.compareTo(string2Value); // Ex: "abc test" "bcd hello". Return by their values
          } else if (isString1IsAlpha) { // Ex: "abc test" "bcd 123"
            return -1;
          } else if (isString2IsAlpha) { // Ex: "abc 123" "bcd test"
            return 1;
          } else {
            return 0; // Both String1 and String2 are digits. Maintain the same order.
          }
        });

    return logs;
  }
}
