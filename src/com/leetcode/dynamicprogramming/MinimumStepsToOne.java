package com.leetcode.dynamicprogramming;

/*
 * 
Given a number n, count minimum steps to minimize it to 1. Below 3 operations are allowed

1) If n is divisible by 2 then we may reduce n to n/2.
2) If n is divisible by 3 then you may reduce n to n/3.
3) Decrement n by 1.

If we observe carefully, the greedy strategy doesn’t work here.
Eg: Given n = 10 , Greedy –> 10 /2 = 5 -1 = 4 /2 = 2 /2 = 1 ( 4 steps ).
But the optimal way is –> 10 -1 = 9 /3 = 3 /3 = 1 ( 3 steps ).

Solution: 
1) Recursively store all 3 computations till reaching 1. In the recursion order, 
if condition for 3 and 2 can change but subtract 1 should be at 3rd condition.
2) Memoitation is possible. Because after some division, they will intersect.

 https://www.geeksforgeeks.org/minimum-steps-minimize-n-per-given-condition/
 */
import java.util.HashMap;
import java.util.Map;

public class MinimumStepsToOne {

	public static void main(String[] args) {
		System.out.println(getMinStepsBottomUp(10));
		System.out.println(getMinSteps(10));
		System.out.println(getMinStepsUsingRecursion(10));
		System.out.println(getMinStepsUsingRecursionMemoi(10, new HashMap<>()));

	}

	public static int getMinStepsUsingRecursion(int num) {
		int x = num, y = num, z = num;

		if (num <= 1)
			return 0;

		if (num % 2 == 0) {
			// System.out.println("X is : " + x);
			x = getMinStepsUsingRecursion(num / 2);
		}

		if (num % 3 == 0) {
			// System.out.println("Y is : " + y);
			y = getMinStepsUsingRecursion(num / 3);
		}

		// System.out.println("Z is : " + z);
		z = getMinStepsUsingRecursion(num - 1);

		// System.out.println(x+" : "+y+" : "+z);
		return 1 + min(min(x, y), z);

	}

	public static int getMinSteps(int n) {
		int result[] = new int[n + 1];
		result[1] = 0;
		for (int i = 2; i <= n; i++) {
			Integer tempResultThree = null;
			Integer tempResultTwo = null;
			Integer tempResultOne = null;
			if (i % 3 == 0) {
				// add 1 to note 1 divide/3 operation done
				tempResultThree = 1 + result[i / 3];
			}
			if (i % 2 == 0) {
				tempResultTwo = 1 + result[i / 2];
			}
			tempResultOne = 1 + result[i - 1];
			result[i] = min(min(tempResultOne, tempResultTwo), tempResultThree);
		}

		return result[n];
	}

	public static int getMinStepsBottomUp(int n) {
		Integer dp[] = new Integer[n + 1];
		dp[1] = 0; // trivial case
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = min(dp[i], 1 + dp[i / 2]);
			if (i % 3 == 0)
				dp[i] = min(dp[i], 1 + dp[i / 3]);
		}
		return dp[n];
	}

	public static int getMinStepsUsingRecursionMemoi(int num, Map<Integer, Integer> map) {
		int x = num, y = num, z = num;

		if (num <= 1)
			return 0;

		if (num % 2 == 0) {
			if (map.containsKey(num / 2)) {
				return map.get(num / 2);
			} else {
				// System.out.println("X is : " + x);
				x = getMinStepsUsingRecursion(num / 2);
				map.put(num / 2, x);
			}
		}

		if (num % 3 == 0) {
			if (map.containsKey(num / 3)) {
				return map.get(num / 3);
			} else {
				// System.out.println("Y is : " + y);
				y = getMinStepsUsingRecursion(num / 3);
				map.put(num / 3, y);
			}
		}
		if (map.containsKey(num - 1)) {
			return map.get(num - 1);
		} else {
			// System.out.println("Z is : " + z);
			z = getMinStepsUsingRecursion(num - 1);
			map.put(num - 1, z);
		}

		// System.out.println(x+" : "+y+" : "+z);
		return 1 + min(min(x, y), z);

	}

	public static int min(Integer a, Integer b) {
		// System.out.println("Min called");
		if (null == a) {
			return b;
		}
		if (null == b) {
			return a;
		}
		if (a < b) {
			return a;
		}
		return b;
	}
}
