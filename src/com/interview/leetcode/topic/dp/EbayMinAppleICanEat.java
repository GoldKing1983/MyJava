package com.interview.leetcode.topic.dp;

/*

Requirement:
1) Find Minimum cost to reach from n to 0.
2) If n is divisible by 3. Then I can move by 2*(n/3) with the cost of 1
3) If n is divisible by 2. Then I can move n/2 with the cost of 1
4) Else I can move only 1 with the cost of 1



1   2   2   3   4   3   4   4   3    4
1   2   3   4   5   6   7   8   9   10

n=1, ans=1
n=2, ans=2
n=3, ans=2
n=4, ans=3
n=5, ans=4
n=6, ans=3... 6/2=3...3 result is 2 + 1=3
n=7, ans=4
n=8, ans=4
n=9, ans=3... 2*(9/3) = 2*3=6.. 9-6=3 3 answer is 2 +1 =3
n=10 ans=4

 */
public class EbayMinAppleICanEat {

  public static int minStepRequired(int n) {
    int[] dp = new int[n + 1]; // ignoring 0.
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 2;

    int dpIndex = 4;
    while (dpIndex <= n) {
      int move3Step = Integer.MAX_VALUE;
      int move2Step = Integer.MAX_VALUE;
      int move1Step = Integer.MAX_VALUE;

      if (dpIndex % 3 == 0) {
        int moveBack = 2 * (dpIndex / 3);
        move3Step = dp[dpIndex - moveBack] + 1;
      }
      if (dpIndex % 2 == 0) {
        int moveBack = (dpIndex / 2);
        move2Step = dp[dpIndex - moveBack] + 1;
      }
      int moveBack = 1; // Ex: for 10... consider 9 also.
      move1Step = dp[dpIndex - moveBack] + 1;

      dp[dpIndex] = Math.min(Math.min(move1Step, move2Step), move3Step);
      dpIndex++;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    for (int i = 4; i <= 10; i++) {
      System.out.println("For " + i + " : " + minStepRequired(i));
    }
  }
}
