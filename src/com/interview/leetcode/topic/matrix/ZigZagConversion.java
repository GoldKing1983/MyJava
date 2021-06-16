package com.interview.leetcode.topic.matrix;

/*

https://leetcode.com/problems/zigzag-conversion/description/

https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/

1) Create an array of numRows strings, arr[numRows]
2) Initialize direction as "down" and row as 0. The direction indicates whether we need to move up or down in rows. 
3) Traverse the input string, do following for every character.
   a) Append current character to string of current row.
   b) If row == maxRow, then change direction to 'up'. To make the zigzag, set row to maxRow-2 like below
   
     
     |
     |  
     |  |    
     |
     
     
   c) If row < 0, then change direction to 'down'.To make the zigzag, set row to 1 like below
   
     |  | 
     |  |  |
     |  |    
     |
   
4) One by one print all strings of arr[].  

=======================================================Data Flow Analysis========================================================
     1   7   13    
     2   6   8   12
     3   5   9   11 
     4   10  

=======================================================Data Flow Analysis========================================================
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

I don't need to exactly like below...
                    P     I    N
                    A   L S  I G
                    Y A   H R
                    P     I

Just down and up is good. StringBuilder manages the column closely without gaps.

                    P 
                    A L 
                    Y A 
                    P 
                     
                    P I 
                    A L  
                    Y A 
                    P 

                    P I 
                    A L S  
                    Y A H
                    P 

                    P I 
                    A L S  
                    Y A H
                    P I

                    P I 
                    A L S I 
                    Y A H R
                    P I

                    P I N
                    A L S I 
                    Y A H R
                    P I

                    P I N
                    A L S I G
                    Y A H R
                    P I

 */
public class ZigZagConversion {
  public String convert(String str, int maxRow) {
    // Corner Case (Only one row) 
    if (maxRow <= 1) return str;

    // Create an array of strings for all n rows 
    StringBuilder[] matrix = new StringBuilder[maxRow];
    for (int i = 0; i < matrix.length; i++) matrix[i] = new StringBuilder();


    int row = 0;
    boolean down = true;

    // Traverse through given string 
    for (char currentChar : str.toCharArray()) {

      matrix[row].append(currentChar);// append current character to current row

      if (down) { // If direction is down, increment, else decrement
        row++;
        if (row == maxRow) {
          down = false;
          row = maxRow-2; // to make zigzag from bottom-up, maxRow-2;
        }
      } else {
        row--;
        if (row < 0) {// If 1st row is reached, change direction to 'down'
          down = true;
          row = 1; // to make zigzag from top-down. Change row to 1;
        }
      }

    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      result.append(matrix[i]);
    }
    return result.toString();

  }
}
