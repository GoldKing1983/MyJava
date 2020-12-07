package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * See how the game works on below URL. Just code for the video.
 * https://www.youtube.com/watch?v=r_dw8iV_52g

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
=============================================Solution Approach - Mathematical - Similar to "MyCalendarII"=============
Step1) If both value at secret and guess matches. It is bull. Just Increment Bull.
 	   Else Increment secretCounter and guessCounter.
Step2) cow += Math.min(secretCounter[i], guessCounter[i]); See the proof below

	 Ex1: Input: secret = "1807", guess = "7810", Output: "1A3B"
	 secretCounter = [1, 1, 0, 0, 0, 0, 0, 1, 0, 0]
	 guessCounter  = [1, 1, 0, 0, 0, 0, 0, 1, 0, 0]

	 Ex2: Input: secret = "1807", guess = "3811", Output: "1A1B"
	 secretCounter = [1, 1, 0, 0, 0, 0, 0, 1, 0, 0]
	 guessCounter  = [0, 2, 0, 1, 0, 0, 0, 0, 0, 0]

	 Ex3: Input: secret = "1801", guess = "0110", Output: "0A3B"
	 secretCounter = [1, 2, 0, 0, 0, 0, 0, 0, 1, 0]
	 guessCounter  = [2, 2, 0, 0, 0, 0, 0, 0, 0, 0]


 */
public class BullsAndCowsBest {
  public String getHint(String secret, String guess) {
    int bullCount = 0;
    int cowCount = 0;
    int[] secretMatchCount = new int[10];
    int[] guessMatchCOunt = new int[10];
    int n = secret.length();
    // Step1
    for (int i = 0; i < n; i++) {
      char secretChar = secret.charAt(i);
      char guessChar = guess.charAt(i);
      if (secretChar == guessChar) bullCount++;
      else {
        int secretCharIndex = secretChar - '0';
        int guessCharIndex = guessChar - '0';
        secretMatchCount[secretCharIndex]++;
        guessMatchCOunt[guessCharIndex]++;
      }
    }
    // Step2
    for (int i = 0; i < 10; i++) {
      cowCount += Math.min(secretMatchCount[i], guessMatchCOunt[i]);
    }

    StringBuilder result = new StringBuilder();
    result.append(bullCount).append("A").append(cowCount).append("B");
    return result.toString();
  }
}
