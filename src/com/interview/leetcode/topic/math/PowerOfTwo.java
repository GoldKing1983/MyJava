package com.interview.leetcode.topic.math;

/*

https://leetcode.com/problems/power-of-two/

Solution 1: Bit count

	Very intuitive. If n is the power of 2, the bit count of n is 1.
	Ex: 1(1), 2(10), 4(100), 8(1000)
	return n > 0 && Integer.bitCount(n) == 1;

Solution 2: Bit operation. From above logic. if(current & previous ==0) then true.
	Ex: 1&2 =0, 3&4=0, 7&8=0
	return n > 0 && ((n & (n-1)) == 0);

Solution3: Divide by 2 till 1 comes
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        while (true) {
            if (n % 2 != 0) return false;
            n = n / 2;
            if (n == 1) return true;
        }
    }
}
