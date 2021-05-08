package com.interview.leetcode.topic.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
Input: logs = ["dig1 8 1 5 1",
               "let1 art can",
               "dig2 3 6",
               "let2 own kit dig",
               "let3 art zero"]
               
Output: logs = ["let1 art can",
                "let3 art zero",
                "let2 own kit dig",
                "dig1 8 1 5 1",
                "dig2 3 6"]
=====================================================Brilliant Hashing Approach==================================================

 */
public class ReorderDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {

    TreeMap<String, String> resultMap = new TreeMap<>();
    Map<String, String> valueKeyMap = new HashMap<>();
    for (int i = 0; i < logs.length; i++) {
      String log = logs[i];
      int index = log.indexOf(' ');
      char c = log.substring(index + 1).charAt(0);
      if (Character.isAlphabetic(c)) {
        // Letter log
        // Build the key starting with 0, that ensures letter-logs before digit-logs
        // If the value present then sort by prefix else sort by suffix.
        String prefixString = log.substring(0, index);
        String suffixString = log.substring(index + 1);

        if (valueKeyMap.containsKey(suffixString)) {
          resultMap.put("0 " + prefixString, log);
        } else {
          resultMap.put("0 " + suffixString, log);
        }

        valueKeyMap.put(suffixString, prefixString);
      } else {
        // Digit log
        // Build the key starting with 1, that ensures digit-logs comes after letter-logs.
        // Append an integer by incoming order, so that same order is maintained for digit log 
        resultMap.put("1 " + (char) i + " ", log);
      }
    }

    int i = 0;
    for (String entry : resultMap.values()) {
      logs[i] = entry;
      i++;
    }

    return logs;
  }
}
