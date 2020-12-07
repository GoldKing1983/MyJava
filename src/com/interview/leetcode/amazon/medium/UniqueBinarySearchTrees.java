package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/unique-binary-search-trees
https://www.youtube.com/watch?v=YDf982Lb84o&feature=youtu.be&t=339

When n = 0, ans=1 --> For multiplication to succeed.
When n = 1, ans=1
When n = 2, ans=2
When n = 3, ans=5
When n = 4, ans=14

============================================================Fibonacci Series============================================================
We can compare this problem with "Fibonacci-Series".
			Set output of 0And1 to 1.
			To get Fibonacci of 2. I need reslut of 1 and 0
			To get Fibonacci of 3. I need reslut of 2 and 1
==============================Solution Approach : Derived from Tushar video. Watch it must ======================================
		====================================High Level Solution====================================
1) "sum" DP value of (leftCount * rightCount) for each node.
2) If n=10... We need to find answer for 1 to 9. Then only 10th count can be formed.
		====================================Low Level Solution====================================
1) Set output of 0And1 to 1.
2) Ex: n = 10.
	Start from 1:
			On Left Side nothing. Becaues nothing below 1. = Dp[0]
			On right of 1, 9Numbers can be added.          = Dp[9] *

	For 2:
			On Left Side 1.								   = Dp[1]
			On right of 1, 9Numbers can be added.          = Dp[8] *

	For 3:
			On Left Side 2.								   = Dp[2]
			On right of 1, 9Numbers can be added.          = Dp[7] *
					.
					.
					.
					.
	For 10:
			On Left Side 9.								   = Dp[9]
			On right of 0. Because nothing is over 10      = Dp[0]
3) Sum all above.

====================================================Data Flow Analysis===========================================================
Ex: n = 0
	Save DP Matrix with 1 for input 0
====================================================Data Flow Analysis===========================================================
Ex: n = 1
	Save DP Matrix with 1 for input 1
====================================================Data Flow Analysis===========================================================
Ex: n = 2
  i is pointing to 1. On left of i there is nothing so 0. On right of i 1 value.
  			1
  			 \
  			  2
  i is pointing to 2. On left of i 1 value. On right of i there is nothing so 0.
  			2
  		   /
  		  1
  ======================
  i = 1, left = 0, right = 1; --> 1*1 = 1
  i = 2, left = 1, right = 0; --> 1*1 = 1 +
  									========
  										2
  									========
====================================================Data Flow Analysis===========================================================
Ex: n = 3
  input = {1,2,3}

  i = 1, left = 0, right = 2; --> 1*2 = 2
  				1
  			   / \
  			  n	 {2,3}
  i = 2, left = 1, right = 1; --> 1*1 = 1 +
				2
  			   / \
  			  1	  3

  i = 3, left = 2, right = 1; --> 1*2 = 2 +
  				3
  			   / \
  			{2,1} n

  									========
  						Ans=			5
  									========
====================================================Data Flow Analysis===========================================================
Ex: n = 4
  input = {1,2,3,4}

  i = 1, left = 0, right = 3; --> 1*5 = 5
  i = 2, left = 1, right = 2; --> 1*2 = 2 +
  i = 3, left = 2, right = 1; --> 2*1 = 2 +
  i = 4, left = 3, right = 0; --> 5*1 = 5 +
  									========
  									    14
  									========

Ex: n = 5
  input = {1,2,3,4,5}

  i = 1, left = 0, right = 4; --> 1*14 = 14
  i = 2, left = 1, right = 3; --> 1*5  =  5 +
  i = 3, left = 2, right = 2; --> 2*2  =  4 +
  i = 4, left = 3, right = 1; --> 5*1  =  5 +
  i = 5, left = 4, right = 0; --> 14*1 = 14 +
  									  ========
  									     42
  									  ========
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int nTotal) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // Saving dp of 0 as 1.
    map.put(1, 1); // Saving dp of 1 as 1

    for (int n = 2; n <= nTotal; n++) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {

        //  Ex: n=10, for 5 left  is 1 to 4. So 5-1 is 4
        int leftCount = map.get(i - 1);

        // Ex: n=10, for 5 right is 6 to 10. So 10-5 is 5
        int rightCount = map.get(n - i);

        sum = sum + (leftCount * rightCount);
      }
      map.put(n, sum);
    }
    return map.get(nTotal);
  }
}
