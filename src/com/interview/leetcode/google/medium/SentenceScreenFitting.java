package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/sentence-screen-fitting/

BruteFourece - very slow.

*/
public class SentenceScreenFitting {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    int row = 0;
    int col = 0;
    int sentenceIndex = 0;
    int n = sentence.length;
    int result = 0;

    while (row < rows) {

      int wordLength = sentence[sentenceIndex].length();
      // Verify whether current row can accomodate the word.
      if (col + wordLength <= cols) {
        col += wordLength;
        sentenceIndex++;

        if (sentenceIndex == n) {
          result++;
          sentenceIndex = 0;
        }
        col++;

      } else {
        col = 0;
        row++;
      }
    }
    return result;
  }
}
