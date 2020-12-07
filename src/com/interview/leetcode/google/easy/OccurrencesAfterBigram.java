package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/occurrences-after-bigram/

Given words "textOfWords" "firstWord" and "secondWord".
If the text contains "first" and "second" word continuously, add "Third" word to result.

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]..
Explanation: "a good" present in 2 places. So picked word after "a good".

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
Explanation: "we will" present in 2 places. So picked word after "we will".


=================================================Solution Approach=================================================
1) Split the word by space.
2) If I compare current and next. I can find the answer.
But problem is I don't know how many such answer exists.
3) So first think would be to use ArrayList to store result.
4) But result expects in String[]. So convert ArrayList<String> to String[].
5) I can avoid un-necessary space, if i count result in 1loop then in next loop fill the String[] which is best.
 */
public class OccurrencesAfterBigram {
  public String[] findOcurrences(String text, String first, String second) {
    String[] arr = text.split(" ");
    int indexLength = 0;

    for (int i = 0; i < arr.length - 2; i++) {
      if (arr[i].equals(first) && arr[i + 1].equals(second)) {
        indexLength++;
      }
    }

    String[] answer = new String[indexLength];
    int answerIndex = 0;

    for (int i = 2; i < arr.length; i++) {
      if (arr[i - 1].equals(second) && arr[i - 2].equals(first)) {
        answer[answerIndex] = arr[i];
        answerIndex++;
      }
    }

    return answer;
  }
}
