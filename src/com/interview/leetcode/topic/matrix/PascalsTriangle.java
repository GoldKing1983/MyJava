package com.interview.leetcode.topic.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/pascals-triangle/

            1
           1 1
         1  2  1
       1   3 3   1
     1   4  6  4   1
     
1) Note: like mirror, leftEnd and rightEnd are filling with same..But below solution doen't utilize this point.

2) From solution point of view. Think of a matrix. Add currentRow,currentVal from previousRow and previousCol
        
 */
public class PascalsTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) return result;

    // for 1row.. just return below
    result.add(Arrays.asList(1));
    if (numRows == 1) return result;

    // for 2row.. just return below
    result.add(Arrays.asList(1, 1));
    if (numRows == 2) return result;

    for (int row = 2; row < numRows; row++) {
      result.add(new ArrayList<>());
      result.get(row).add(1);

      List<Integer> previousRow = result.get(row - 1);
      for (int col = 1; col < row; col++) {
        int diagonal = previousRow.get(col); //  /
        int antiDiagonal = previousRow.get(col - 1);// \
        result.get(row).add(diagonal + antiDiagonal);
      }

      result.get(row).add(1);
    }
    return result;
  }
}
