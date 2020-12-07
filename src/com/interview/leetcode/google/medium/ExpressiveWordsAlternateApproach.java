package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/expressive-words/

Based on problem and solution "LongPressedName"

Could be improved to run "targetWord" cached to variables instead of running everytime.
*/
public class ExpressiveWordsAlternateApproach {
  public int expressiveWords(String target, String[] words) {
    int ans = 0;
    for (String word : words) {
      if (isLongPressedName(word, target)) ans++;
    }
    return ans;
  }

  public boolean isLongPressedName(String dictWord, String targetWord) {
    int dictWordIndex = 0, targetWordIndex = 0;
    while (dictWordIndex < dictWord.length() && targetWordIndex < targetWord.length()) {
      char dictWordChar = dictWord.charAt(dictWordIndex++);
      char targetWordChar = targetWord.charAt(targetWordIndex++);
      if (dictWordChar != targetWordChar) return false;

      int dictWordCharCount = 1;
      while (dictWordIndex < dictWord.length()) {
        if (dictWordChar != dictWord.charAt(dictWordIndex)) break;
        dictWordIndex++;
        dictWordCharCount++;
      }

      int targetWordCharCount = 1;
      while (targetWordIndex < targetWord.length()) {
        if (targetWord.charAt(targetWordIndex) != targetWordChar) break;
        targetWordCharCount++;
        targetWordIndex++;
      }
      if (dictWordCharCount == targetWordCharCount) continue;
      if (targetWordCharCount < dictWordCharCount) return false;
      if (targetWordCharCount < 3) return false;
    }
    // For Case "ab", "aa". Here n size will be 1 and t size will be 2
    if (dictWordIndex != dictWord.length()) return false;
    // For Case "a", "ab". Here n size will be 1 and t size will be 1
    if (targetWordIndex != targetWord.length()) return false;
    return true;
  }
}
