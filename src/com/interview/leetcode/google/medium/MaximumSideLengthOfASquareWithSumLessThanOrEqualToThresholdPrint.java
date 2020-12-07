package com.interview.leetcode.google.medium;

/*




*/
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThresholdPrint {
  public int maxSideLength(int[][] mat, int threshold) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] preSums = new int[n + 1][m + 1];
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int leftPresum = preSums[i + 1][j];
        int topPresum = preSums[i][j + 1];
        int diagonalPreSum = preSums[i][j];
        int source = mat[i][j];
        int currentPresum = source + leftPresum + topPresum - diagonalPreSum;

        preSums[i + 1][j + 1] = currentPresum;

        if (i - max >= 0 && j - max >= 0) {
          int topMaxSquarePresum = preSums[i - max][j + 1];
          int leftMaxSquarePresum = preSums[i + 1][j - max];
          int diagonalMaxSquarePresum = preSums[i - max][j - max];
          System.out.println(
              "For the Position:"
                  + (i)
                  + ","
                  + (j)
                  + "==> "
                  + currentPresum
                  + "-"
                  + leftMaxSquarePresum
                  + "-"
                  + topMaxSquarePresum
                  + "+"
                  + diagonalMaxSquarePresum
                  + "="
                  + (currentPresum
                      - leftMaxSquarePresum
                      - topMaxSquarePresum
                      + diagonalMaxSquarePresum));
          if (currentPresum - leftMaxSquarePresum - topMaxSquarePresum + diagonalMaxSquarePresum
              <= threshold) {
            System.out.println("square is <= threshold. So incrementing max side length");
            max += 1;
          } else {
            System.out.println("square is > threshold. So not valid square");
          }
        }
      }
    }
    // for (int i = 0; i <= m; i++) {
    //     System.out.println(Arrays.toString(sum[i]));
    // }

    return max;
  }
}
