package com.leetcode.dynamicprogramming;


public class SwapAdjacent {
	
	private static String word = "12345"; //I assume the consecutive characters are not the same
	
	public static void main(String[] args) {
		System.out.println(adj(9)); //8
	}
	
	public static int adj(int i) { //Returns the number of permutations
		if (i == 0) return 1;
		else if (i < 0) return 0;
		
		return adj(i - 1) + adj(i - 2);
	}
}