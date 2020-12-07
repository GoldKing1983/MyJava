package com.interview.leetcode.google.easy;

/*
 *
https://leetcode.com/problems/design-compressed-string-iterator/

Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

==========================================Solution Approach==========================
The idea is straight forward.

If the current character is not consumed (count > 0), output the current character.
If current character is consumed (count == 0), fetch next character. If no more, output ' '
==============================================================================================================================
 */
public class DesignCompressedStringIterator {
  String compressedString;
  Character cur;
  int count;
  int i;

  public DesignCompressedStringIterator(String compressedString) {
    this.compressedString = compressedString;
    this.cur = null;
    this.i = 0;
    this.count = 0;
  }

  public char next() {
    if (count == 0) {
      if (i >= compressedString.length()) {
        return ' ';
      }
      cur = compressedString.charAt(i++);
      while (i < compressedString.length()
          && compressedString.charAt(i) >= '0'
          && compressedString.charAt(i) <= '9') {
        count = 10 * count + (compressedString.charAt(i) - '0');
        i++;
      }
    }
    count--;
    return cur;
  }

  public boolean hasNext() {
    return i < compressedString.length() || count != 0;
  }
}
