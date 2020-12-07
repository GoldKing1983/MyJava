package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/filling-bookcase-shelves
 */
public class FillingBookcaseShelves {
  private int recur(
      int[][] books, int bookIndex, int shelfMaxWidth, int currentRowShelfWidth, int maxHeight) {
    if (bookIndex == books.length) return 0;

    // implies this is the first book of new row we need to include it, no other alternative
    if (currentRowShelfWidth == 0) {
      int updatedCurrRowShelfWidth = currentRowShelfWidth + books[bookIndex][0];
      int updatedMaxHeight = Math.max(maxHeight, books[bookIndex][1]);
      int heightInclusion =
          recur(books, bookIndex + 1, shelfMaxWidth, updatedCurrRowShelfWidth, updatedMaxHeight);
      return Math.max(heightInclusion, books[bookIndex][1]);
    }
    int heightInclusion = Integer.MAX_VALUE;

    // inclusion
    if (currentRowShelfWidth + books[bookIndex][0] <= shelfMaxWidth) {
      int updatedCurrentRowShelfWidth = currentRowShelfWidth + books[bookIndex][0];
      int updateMaxHeight = Math.max(maxHeight, books[bookIndex][1]);
      heightInclusion =
          recur(books, bookIndex + 1, shelfMaxWidth, updatedCurrentRowShelfWidth, updateMaxHeight);
      heightInclusion = Math.max(heightInclusion, books[bookIndex][1]);
    }

    // exclusion. But keep the maxHeight
    int heightExclusion = recur(books, bookIndex, shelfMaxWidth, 0, 0) + maxHeight;

    return Math.min(heightExclusion, heightInclusion);
  }

  public int minHeightShelves(int[][] books, int shelfWidth) {
    return recur(books, 0, shelfWidth, 0, 0);
  }
}
