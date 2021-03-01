package com.interview.leetcode.topic.recursion;

/*
===========================================================Requirement===========================================================
https://leetcode.com/problems/house-robber/
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.
=========================================================Initial Thought=========================================================
Same problem as GroupSumImportant, but here for include case jump is 2.
========================================================Solution Approach========================================================
For Each of Index do below operation.
1) steal from current house and move on to n+2 house.
2) skip steal from current house and move on to n+1(next) house
3) Return max of step (1, 2)

BottomUp/TopDown both the Recursion works, because doing logic from 0 to n or n to 0 both results same
=======================================================Data Flow Analysis========================================================
Ex1: [100,2,3,50]  	Ans:150
Don't confuse the below Tree, because for 4 house from 0to3, why 5 was included.
For 4 house from 0 to 3. From 3 recursion will try go till 5. Because after steal, logic jump 2 index.
When logic sees 4 or 5, it returns sum0.

							============TopDown - for 4 house 0to3============
											0
										/        \
									   2           1
									 /  \         /  \
								    4     3      3     2
								         / \    / \   / \
								        5   4  5   4 4	 3
								   	       				/  \
								   	    			   5	4
							============BottomUp============
										      0(150)
										/              \
									2(50+100)          1(52)
									 /  \           /         \
								4(3+0) 3(50)     3(50+2)      2(50)
								      	 / \      /    \       /    \
								  5(0+50) 4(0) 5(0+50) 4(0) 4(0+20)  3(50)
										   			  			      /  \
										   			  		      5(0+50) 4(0)
=========================================================================================================
Ex1: [100,2,20,10]  	Ans:120
							============TopDown- for 5 house 0to4============
											0
										/        \
									   2           1
									 /  \         /  \
								    4     3      3     2
								         / \    / \   / \
								        5   4  5   4 4	 3
								   	       				/  \
								   	    			   5	4
							============BottomUp============
										       0(120)
										/              \
									  2(20+100)         1(20)
									 /  \           /         \
								4(20+0) 3(10)     3(10+2)      2(20)
								      	 / \      /    \       /    \
								  5(0+10) 4(0) 5(0+10) 4(0) 4(0+20)  3(10)
										   			  			      /  \
										   			  		      5(0+10) 4(0)
=========================================================================================================
Ex1: [50,75,20,10]  	Ans:85
							============TopDown- for 5 house 0to4============
											0
										/        \
									   2           1
									 /  \         /  \
								    4     3      3     2
								         / \    / \   / \
								        5   4  5   4 4	 3
								   	       				/  \
								   	    			   5	4
							============BottomUp============
										       0(85)
										/              \
									  2(20+50)         1(85)
									 /  \           /         \
								4(20+0) 3(10)     3(10+75)     2(20)
								      	 / \      /    \       /    \
								  5(0+10) 4(0) 5(0+10) 4(0) 4(0+20)  3(10)
										   			  			      /  \
										   			  		      5(0+10) 4(0)
=========================================================================================================
 */

public class HouseRobberRecursion {
  public int rob(int[] wealth) {
    return findMaxStealRecursive(wealth, 0, wealth.length);
  }

  private int findMaxStealRecursive(int[] wealth, int currentHouse, int totalHouse) {
    if (currentHouse >= totalHouse) return 0;

    // steal from current house and skip one to steal from the next house
    int robCurrentHouse = findMaxStealRecursive(wealth, currentHouse + 2, totalHouse) + wealth[currentHouse];
    // skip current house to steel from the adjacent house
    int skipCurrentHouse = findMaxStealRecursive(wealth, currentHouse + 1, totalHouse);

    return Math.max(robCurrentHouse, skipCurrentHouse);
  }

  private int findMaxStealRecursiveBottomUp(int[] wealth, int currentHouse) {
    if (currentHouse < 0 ) return 0;

    // steal from current house and skip one to steal from the next house
    int robCurrentHouse = findMaxStealRecursiveBottomUp(wealth, currentHouse - 2) + wealth[currentHouse];
    // skip current house to steel from the adjacent house
    int skipCurrentHouse = findMaxStealRecursiveBottomUp(wealth, currentHouse - 1);

    return Math.max(robCurrentHouse, skipCurrentHouse);
  }
}
