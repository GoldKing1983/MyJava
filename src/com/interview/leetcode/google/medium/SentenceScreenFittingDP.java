package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/sentence-screen-fitting/

1) Create the entire sentence with a space between each words.
2) For every iteration of the row, try to fit "cols size word"
Ex: ["hello","world"] rows=5 cols=8....After joining...entireSentence: 'hello world ' and sentence length is : 12
Try to fit 8 size... that means... if there is a space in "entireSentence" at position8. then it is fitting.
Else reduce the total size by 1. Keep moving.

=======================================================================================================================
["hello","world"]
5
8
Output: 2
entireSentence: 'hello world ' and sentence length is : 12
======Processing Row: 0 ===========
Col is not Fitting. So Decrementing total to : 7
Col is not Fitting. So Decrementing total to : 6
======Processing Row: 1 ===========
Col is not Fitting. So Decrementing total to : 13
Col is not Fitting. So Decrementing total to : 12
======Processing Row: 2 ===========
Col is not Fitting. So Decrementing total to : 19
Col is not Fitting. So Decrementing total to : 18
======Processing Row: 3 ===========
Col is not Fitting. So Decrementing total to : 25
Col is not Fitting. So Decrementing total to : 24
======Processing Row: 4 ===========
Col is not Fitting. So Decrementing total to : 31
Col is not Fitting. So Decrementing total to : 30
======All Rows Processed===========
total : 30 sentenceLength : 12 Result(30/12) : 2
=======================================================================================================================
["hello","world"]
5
5
Output: 2
entireSentence: 'hello world ' and sentence length is : 12
======Processing Row: 0 ===========
Col is Fitting. So Incrementing total to : 6
======Processing Row: 1 ===========
Col is Fitting. So Incrementing total to : 12
======Processing Row: 2 ===========
Col is Fitting. So Incrementing total to : 18
======Processing Row: 3 ===========
Col is Fitting. So Incrementing total to : 24
======Processing Row: 4 ===========
Col is Fitting. So Incrementing total to : 30
======All Rows Processed===========
total : 30 sentenceLength : 12 Result(30/12) : 2
=======================================================================================================================
["a", "bcd", "e"]
3
6
Output: 2

entireSentence: 'a bcd e ' and sentence length is : 8
======Processing Row: 0 ===========
======Processing Row: 1 ===========
Col is not Fitting. So Decrementing total to : 11
Col is not Fitting. So Decrementing total to : 10
======Processing Row: 2 ===========
======All Rows Processed===========
total : 16 sentenceLength : 8 Result(16/8) : 2
=======================================================================================================================

 */
public class SentenceScreenFittingDP {
  public int wordsTyping(String[] sentence, int rows, int cols) {

    String entireSentence = String.join(" ", sentence) + " ";
    int sentenceLength = entireSentence.length();

    int totalLength = 0;
    while (rows-- > 0) {
      totalLength += cols;

      // Ex: sentence=hello.. rows= 1000.. cols = 1. This can never fit and answer is 0.
      // If it is guaranteed to be 1 output all time. Then below condition can be while(true)
      while (totalLength > 0) {
        if (entireSentence.charAt(totalLength % sentenceLength) == ' ') {
          totalLength++;
          break;
        }
        totalLength--; // reduce totalLength by 1 and try to fit it.
      }
    }
    return totalLength / sentenceLength;
  }
}
