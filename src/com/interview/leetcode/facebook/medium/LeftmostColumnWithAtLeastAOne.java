package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.BinaryMatrix;
import java.util.List;

/*


Input: mat = [[0,0,1,1],[0,1,1,1],[0,0,0,1]]
Output: 1

for 0th row. low=0, high=3...binSearch returns index2. So next search space high sets to index2
for 1st row. low=0, high=2...binSearch returns index1. So next search space high sets to index1
for 0th row. low=0, high=1...binSearch returns index2. but already we have answer in lowerIndex. So ignored.

1) Input contains only 0s and 1s.
2) For each row Numbers are in ascending order from leftToRight
3) So if there is a 1, there must be only 1 after that.
4) For each verify 1present.
5) If 1present then in nextRow, search space high changes to current1Index. Low never changes.

 */
public class LeftmostColumnWithAtLeastAOne {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> rowColSize = binaryMatrix.dimensions();
    int maxRow = rowColSize.get(0) - 1;
    int maxCol = rowColSize.get(1) - 1;
    int low = 0, high = maxCol;
    boolean found = false;
    for (int row = 0; row <= maxRow; row++) {
      int current1Index = binSearch(row, low, high, binaryMatrix);
      if (current1Index <= high) {
        found = true;
        high = current1Index;
      }
    }
    return found ? high : -1;
  }

  // Find first1. If 1found go left. Else go right.
  private int binSearch(int row, int low, int high, BinaryMatrix binaryMatrix) {

    if (low > high) return low; // low goes >n if not found

    int mid = low + (high - low) / 2;
    int midValue = binaryMatrix.get(row, mid);

    if (midValue == 1) return binSearch(row, low, mid - 1, binaryMatrix);

    return binSearch(row, mid + 1, high, binaryMatrix);
  }
}
