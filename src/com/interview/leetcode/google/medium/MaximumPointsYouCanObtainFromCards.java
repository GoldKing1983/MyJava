package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will
maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.

Input: cardPoints = [1,1000,1], k = 1
Output: 1
Explanation: You cannot take the card in the middle. Your best score is 1.

Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
Output: 202
===============================================Solution Approach - Circular Sliding Window======================================
1) Important point to note is player cannot choose numbers discontinuously.

2) This leads the player to choose from "n-k" to "k" numbers only.
Ex: [1,2,3,4,5,6,7,8] k=3. Player options are [6,7,8,1,2,3]

3) So do sliding window from "n-k to k" or
	in 2 parts 1) n-k to n and 2) 0 to k.  Doing in 2 parts is better and avoids if conditions i.e set right to 0 when right reaches max


 */
public class MaximumPointsYouCanObtainFromCards {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int right = n - k;
    int maxScore = 0;

    // Generating First window with right alone. Move right from n-k to n. No Sliding started
    while (right < n) maxScore += cardPoints[right++];

    int currentMaxScore = maxScore;
    int left = n - k;
    right = 0; // Reset right to 0 to do circular sliding window.
    // Starting Sliding window from left=n-k, right=0.
    while (right < k) {
      currentMaxScore -= cardPoints[left++];
      currentMaxScore += cardPoints[right++];
      maxScore = Math.max(currentMaxScore, maxScore);
    }
    return maxScore;
  }
}
