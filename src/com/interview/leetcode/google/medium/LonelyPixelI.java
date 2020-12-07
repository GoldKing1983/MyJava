package com.interview.leetcode.google.medium;
/*
https://leetcode.com/problems/lonely-pixel-i/
Given a picture consisting of black and white pixels, find the number of black lonely pixels.
A black pixel is lonely, if same row and same column don't have any other black pixels.


Ex:
[["W","W","B"],
 ["W","B","W"]]

Output : 2
===========================Solution Approach=============================================
1) In Loop1, Count Number of 'B' for a row and column. Save it in array.
Ex:
[["W","W","B"],
 ["W","B","W"]]

rowCount = [1, 1]
colCount = [0, 1, 1]
2) In Loop2, for each 'B' if rowCount[row] + colCount[col] == 2 "increment lonely pixel".
==========================================================================================
1) I cannot fetch rowCount and colCount alone to get the total count.
2) See example below where rowCount and colCount index where "B" updated varies
Ex:
[["W","W","B"],
 ["W","B","W"],
 ["W","W","W"]]
 Output:2

 rowCount = [1, 1, 0]
 colCount = [0, 1, 1]
 3) I cannot think rowCount from "0 to n-1" and colCount from "n-1 to 0". Still that fails.
 See below example.
 Ex:
 [["W","W","W"],
  ["W","W","W"],
  ["W","W","B"]]
 Output:1

 rowCount = [0, 0, 1]
 colCount = [0, 0, 1]

==========================================================================================
 */
public class LonelyPixelI {
  public int findLonelyPixel(char[][] picture) {
    int maxRow = picture.length, maxCol = picture[0].length;
    int[] rowCount = new int[maxRow], colCount = new int[maxCol];
    for (int row = 0; row < maxRow; row++)
      for (int col = 0; col < maxCol; col++)
        if (picture[row][col] == 'B') {
          rowCount[row]++; // Array is mutable. So ++ is enough. rowCount[i]+=1 is not necessary;
          colCount[col]++;
        }

    int count = 0;
    for (int row = 0; row < maxRow; row++)
      for (int col = 0; col < maxCol; col++)
        if (picture[row][col] == 'B' && rowCount[row] + colCount[col] == 2) count++;

    return count;
  }
}
