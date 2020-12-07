package com.interview.leetcode.google.medium;

/*

==================================================Requirement==================================================
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

Example 1: (From the famous "Die Hard" example)
Input: x = 3, y = 5, z = 4
Output: True

Input: x = 2, y = 6, z = 5
Output: False
================================================Solution Approach==========================================================
if GCD of x and y is multiple of z then answer is true.

			x = 4, y = 6, z = 8.
			GCD(4, 6) = 2
			2 is multiple of 8
==============================================================================================================================
Input: x = 3, y = 5, z = 4 Output: True

1) Fill the 5-jug up completely
2) Use the water from the 5-jug to fill up the 3-jug.
3) Pour out the 3-gallon jug to source.
4) Transfer the water from the 5-jug to the three jug.
5) You're left with 2 gallons in the 3-jug. And nothing in the 5-jug.
From this step. Now 2 ways 4 can be found.
Way1 : Pour 2 gallon jug into 4 gallon jug. Doing step 1 to 5, will get another 2.
Way2 : Fill 5 gallon jug. 3-Gallon can take only 1 gallon. Fill 1 gallon from 5 gallon jut to 3 gallon jug.
Now 5 gallon jug has 4 gallon water.
 */
public class WaterAndJugProblemGCD {
  public boolean canMeasureWater(int x, int y, int z) {
    // Ex: x=2,y=2,z=6
    if (x + y < z) return false;
    // Ex: x=2,y=2,z=0
    if (z == 0) return true;
    // Ex: x=0,y=2,z=2
    if (x == 0) return y == z;
    // Ex: x=2,y=0,z=2
    if (y == 0) return x == z;
    // Ex: x=3,y=5,z=4
    return z % gcd(x, y) == 0;
  }

  public int gcd(int a, int b) {
    while (true) {
      int temp = a;
      a = b % a;
      b = temp;
      if (a == 0) break;
    }
    return b;
  }
}
