package com.interview.leetcode.linkedin.easy;

/*
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.
=============================================Solution Approach=============================================
1) BottomUp Recursion works, because doing logic from 0 to n or n to 0 both results same
2) Consider evaluating single entry at each point like Tree Problems.

For Each of Index do below operation.
1) 		steal from current house and move on to n+2 house.
2) skip steal from current house and move on to n+1(next) house
3) Return max of step (1, 2)
=============================================Data Flow Analysis=============================================
Ex1: [100,2,3,50]  	Ans:150 dp=[100,100,103,150]
							============TopDown - for 5 house 0to4============
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
    int robCurrentHouse =
        findMaxStealRecursive(wealth, currentHouse + 2, totalHouse) + wealth[currentHouse];
    // skip current house to steel from the adjacent house
    int skipCurrentHouse = findMaxStealRecursive(wealth, currentHouse + 1, totalHouse);

    return Math.max(robCurrentHouse, skipCurrentHouse);
  }
}
