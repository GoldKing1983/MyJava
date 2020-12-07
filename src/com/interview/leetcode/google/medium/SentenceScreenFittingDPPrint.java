package com.interview.leetcode.google.medium;

/*

*/
public class SentenceScreenFittingDPPrint {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    String entireSentence = String.join(" ", sentence) + " ";
    int sentenceLength = entireSentence.length();
    System.out.println(
        "entireSentence: '" + entireSentence + "'" + " and sentence length is : " + sentenceLength);
    int total = 0;
    for (int i = 0; i < rows; i++) {
      total += cols;
      System.out.println("======Processing Row: " + i + " ===========");
      if (entireSentence.charAt(total % sentenceLength) == ' ') {
        total++;
        System.out.println("Col is Fitting. So Incrementing total to : " + total);

      } else {
        while (total > 0 && entireSentence.charAt((total - 1) % sentenceLength) != ' ') {
          total--;
          System.out.println("Col is not Fitting. So Decrementing total to : " + total);
        }
      }
    }
    System.out.println("======All Rows Processed===========");
    System.out.println("total : " + total);
    System.out.println("sentenceLength : " + sentenceLength);
    System.out.println("Result : " + total / sentenceLength);
    return total / sentenceLength;
  }
}
