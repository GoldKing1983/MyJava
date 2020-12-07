package com.sample.basics;

/*
1) The multiplication and division based approach doesn’ work if one
of the numbers is 0 as the product becomes 0 irrespective of the other number.

2) Both Arithmetic solutions may cause arithmetic overflow.
If x and y are too large, addition and multiplication may go out of integer range.

3) If x and y are same then, I can return without swap. This is optimization and never change logic in
Ex:
		101
		101
		===
		000
		===

*/
public class SwapWithoutThirdVariable {

  public static void main(String[] args) {
    SwapWithoutThirdVariable s = new SwapWithoutThirdVariable();
    s.swapUsingXOR();
  }

  /*
  1010
  0101
  =====
   */
  private void swapUsingXOR() {
    int x = 5;
    int y = 5;
    System.out.println("swapUsingXOR : Input x " + x);
    System.out.println("swapUsingXOR : Input y " + y);
    // Code to swap 'x' (1010) and
    //				'y' (0101)
    x = x ^ y; // x now becomes 15 (1111)
    y = x ^ y; // y becomes 10 (1010)
    x = x ^ y; // x becomes 5 (0101)

    System.out.println("swapUsingXOR : Output x " + x);
    System.out.println("swapUsingXOR : Output x " + y);
  }

  private void swapUsingAdditionSubtraction() {
    int x = 10;
    int y = 5;

    x = x + y; // 15
    y = x - y; // 10
    x = x - y; // 5
  }

  private void swapUsingMultiplicationDivision() {
    int x = 10;
    int y = 5;

    x = x * y; // 50
    y = x / y; // 10
    x = x / y; // 5
  }
}
