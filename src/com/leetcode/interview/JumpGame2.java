package com.leetcode.interview;

import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/jump-game-ii/
 *
=======================================================================
Input: [2]
Output: 0
=======================================================================
Input: [2,3,1,1,3,1,1,3]
Output: 3
Explanation: The minimum number of jumps to reach the last index is 3.
    Jump 1 step from index 0 to 1, then 3 steps to the 4th index and then last index.

=========Solution Approach===============================================
1) Look into "JumpGame.java"
2) General solution is for each index save what is the minimal jump to reach that index.
Ex: Input: [2,3,1,1,4]
3) To reach 0th index it is 0 only. Because I start from 0. So we don't need to fill 0th index.
4) In Index0 number is 2. So I can fill below
		0  1  1  ∞  ∞  ∞  ∞  ∞  ∞
5) In Index1 number is 3. So I can fill below
		0  1  1  2  2  2 ∞  ∞  ∞
On analyzing the above pattern, if an index is set to minimum jump it cannot change for that point.

=======================================================================
 Input: [7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3] Output: 2

		 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14
		 ============================================
	 	 0  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞  ∞ [Initial]
For	7	 0  1  1  1  1  1  1  1  ∞  ∞  ∞  ∞  ∞  ∞  ∞
For	0	 0  1  1  1  1  1  1  1  ∞  ∞  ∞  ∞  ∞  ∞  ∞
For	9	 0  1  1  1  1  1  1  1  2  2  2  2  ∞  ∞  ∞
For 6	 0  1  1  1  1  1  1  1  2  2  2  2  ∞  ∞  ∞ [No Change]
For 9    0  1  1  1  1  1  1  1  2  2  2  2  2  2  ∞
For 6    0  1  1  1  1  1  1  1  2  2  2  2  2  2  ∞ [No Change]
For 1    0  1  1  1  1  1  1  1  2  2  2  2  2  2  ∞ [No Change]
For 7    0  1  1  1  1  1  1  1  2  2  2  2  2  2  2 [Reached]

	map: {7=1, 11=2, 13=2, 14=2}

=======================================================================
 Input: [2  3  1  1  4] Output: 2
		 ===============
	 	 0  ∞  ∞  ∞  ∞ [Initial]
For	2	 0  1  1  ∞  ∞
For	3	 0  1  1  2  2  [Reached]

	map: {2=1, 4=2}

 */
public class JumpGame2 {

  public static int jump(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int maxGoJumpIndex = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int currentMaxGoJumpIndex = i + nums[i];
      if (currentMaxGoJumpIndex > maxGoJumpIndex) {
        maxGoJumpIndex = currentMaxGoJumpIndex;
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(i); // equal or lower value
        if (entry == null) map.put(currentMaxGoJumpIndex, 1);
        else map.put(currentMaxGoJumpIndex, entry.getValue() + 1);
      }
      if (maxGoJumpIndex >= nums.length - 1) {
        return map.ceilingEntry(maxGoJumpIndex).getValue();
      }
    }

    return 0;
  }
}
