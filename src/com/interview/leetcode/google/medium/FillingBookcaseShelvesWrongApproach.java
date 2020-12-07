package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/filling-bookcase-shelves

1) Saw the input and tried below approach.
2) Eagerly choose from leftToRight and then rightToLeft. Failing for most of cases.
 */
public class FillingBookcaseShelvesWrongApproach {
  public int minHeightShelves(int[][] books, int shelfWidth) {
    int maxRowLeftToRight = 0;
    int currentRowMaxHeight = 0;
    int currentRowMaxWidth = 0;
    for (int i = 0; i < books.length; ) {
      int currentBookWidth = books[i][0];
      int currentBookHeight = books[i][1];
      if (currentRowMaxWidth + currentBookWidth <= shelfWidth) {
        // can accomodate current book in current row of shelf
        currentRowMaxWidth += currentBookWidth;
        currentRowMaxHeight = Math.max(currentRowMaxHeight, currentBookHeight);
        i++;
      } else { // move on to next row of shelf, with same books. So i not incremented.
        maxRowLeftToRight += currentRowMaxHeight;
        currentRowMaxHeight = 0; // Reset
        currentRowMaxWidth = 0; // Reset
      }
    }
    maxRowLeftToRight += currentRowMaxHeight;

    int maxRowRightToLeft = 0;
    currentRowMaxHeight = 0;
    currentRowMaxWidth = 0;
    for (int i = books.length - 1; i >= 0; ) {
      int currentBookWidth = books[i][0];
      int currentBookHeight = books[i][1];
      if (currentRowMaxWidth + currentBookWidth <= shelfWidth) {
        // can accomodate current book in current row of shelf
        currentRowMaxWidth += currentBookWidth;
        currentRowMaxHeight = Math.max(currentRowMaxHeight, currentBookHeight);
        i--;
      } else { // move on to next row of shelf, with same books. So i not incremented.
        maxRowRightToLeft += currentRowMaxHeight;
        currentRowMaxHeight = 0; // Reset
        currentRowMaxWidth = 0; // Reset
      }
    }
    maxRowRightToLeft += currentRowMaxHeight;

    return Math.min(maxRowLeftToRight, maxRowRightToLeft);
  }
}
