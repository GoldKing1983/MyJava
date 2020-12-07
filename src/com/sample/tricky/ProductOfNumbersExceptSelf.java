package com.sample.tricky;

/*

===================Step1=====================================
1	2	4	5
* \ * \	* \	*
1	1	2	8 ===> Result1 leftToRight... Fill 1 in first

1*1 = 1
2*1 = 2
4*2 = 8

===================Step2=====================================
1	2	4	5
* / * /	* /	*
40	20	5	1 ===> Result2 rightToLeft... Fill 1 in last

5*1 = 5
4*5 = 20
2*20= 40
===================Step3=====================================

1   1   2   8
*   *	*	*
40	20	5	1
=   =   =   =
40  20  10  8
==================================================================
 */

public class ProductOfNumbersExceptSelf {

  public int[] productExceptSelf(int[] arr) {
    int i, n = arr.length;
    int[] leftToRight = new int[n];
    int[] rightToLeft = new int[n];

    leftToRight[0] = 1;
    for (i = 1; i < n; i++) {
      leftToRight[i] = leftToRight[i - 1] * arr[i - 1];
    }
    rightToLeft[n - 1] = 1;
    for (i = n - 2; i >= 0; i--) {
      rightToLeft[i] = rightToLeft[i + 1] * arr[i + 1];
    }
    for (i = 0; i < n; i++) {
      leftToRight[i] = leftToRight[i] * rightToLeft[i];
    }
    return leftToRight;
  }
}
