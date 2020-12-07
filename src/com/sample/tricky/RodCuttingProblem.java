package com.sample.tricky;

/*
https://www.educative.io/edpresso/the-rod-cutting-problem

1) rod can be cut into any given pieces.
Ex: 5 inch length. Can be cut into 1,3 inch length. price 10,15
Ex: 5 inch length. Can be cut into 1,2,3 inch length. price 10,12,15
Ex: 5 inch length. Can be cut into 1,4 inch length. price 10,20
Any combination possible.

Same problem as Coin-Change with weightage.

		n=5. Can cut into 1,2,3,4 and price is 2, 5, 7, 8
 		      0   1   2   3   4   5
 		  ============================================
	  {1} || [0,  2,  4,  6,  8, 10 ] ==> For 1
    {1,2} || [0, 2P,  5,  7, 10, 12 ] ==> For 1,2
  {1,2,3} || [0, 2P, 5P,  7, 10, 12 ] ==> For 1,2,3
{1,2,3,4} || [0, 2P, 5P, 7P, 10, 12 ] ==> For 1,2,3,4

 */
public class RodCuttingProblem {
  static int cutRod(int[] pieces, int[] price, int n) {
    return 0;
  }

  public static void main(String args[]) {
    int price[] = new int[] {2, 5, 7, 8};
    int n = 5;
    System.out.println("Maximum profit is " + cutRod(new int[] {1, 2, 3, 4}, price, n));
  }
}
