package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/reorder-data-in-log-files/
============================================================Requirement==========================================================
You have an array of logs.  Each log is a space delimited string of words.
For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word 
after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically 
ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.
===============================================================Example1==========================================================
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


 */
public class ReorderDataInLogFilesBest {
  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> logComparator = (final String s1, final String s2) -> {
      int string1CutIndexPos = s1.indexOf(' ');
      int string2CutIndexPos = s2.indexOf(' ');
      char string1FirstCharAfterCut = s1.charAt(string1CutIndexPos + 1);
      char string2FirstCharAfterCut = s2.charAt(string2CutIndexPos + 1);

      boolean isString1IsDigit = Character.isDigit(string1FirstCharAfterCut);
      boolean isString2IsDigit = Character.isDigit(string2FirstCharAfterCut);
      if (isString1IsDigit && isString2IsDigit) {
        return 0; // Both String1 and String2 are digits
      } else if (isString1IsDigit) {
        return 1; // String1 is digit, String2 is alpha
      } else if (isString2IsDigit) {
        return -1; // String2 is digit, String1 is alpha
      } else {
        // ============================Case : Both String1 and String2 are alpha============================
        int isBothString1AndString2Equal =
            s1.substring(string1CutIndexPos + 1).compareTo(s2.substring(string2CutIndexPos + 1));

        if (isBothString1AndString2Equal == 0) {
          // If String1 and String2 is same after cut position. Then sort from 0th to cut position. 
          // Ex: "abc hello" "bcd hello"
          return s1.substring(0, string1CutIndexPos).compareTo(s2.substring(0, string2CutIndexPos));
        }
        return isBothString1AndString2Equal;
      }

    };

    Arrays.sort(logs, logComparator);
    return logs;
  }
}
