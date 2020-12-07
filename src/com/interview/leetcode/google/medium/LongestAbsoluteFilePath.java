package com.interview.leetcode.google.medium;

/*
 * https://leetcode.com/problems/longest-absolute-file-path/
 *
 * Just code for the requirement
 *
 * The number of tabs is my depth or level and for each depth I store the current path length.

0) Find the level where the file/folder lands. The level is found out by "lastIndexOf"
      // for hello  -> -1 will be returned ==> So it must be root
      // for \t     -> 0 will be returned.
      // for \t\t   -> 1 will be returned.
      // for \t\t\t -> 2 will be returned.

1) For the current-folder or file, I need to add parent folders length.
2) The parent's folder length is saved in levels[].
3) So "currentLengthForThatLevel" = "parentLength" + "currentLength" + 1
// Adding +1 for "/". Ex: abc/1.txt -->output8. So need to add +1 for "/"
4) Calculate Length only when there is a file. If input contains only folder then answer is 0.

 */
public class LongestAbsoluteFilePath {
  public int lengthLongestPath(String input) {
    String[] inp = input.split("\n");
    int[] levels = new int[inp.length];
    int maxLength = 0;
    for (String s : inp) {

      int level = s.lastIndexOf('\t') + 1;

      // remove the "\t" to calculate the actual length of current folder/file.
      // Ex: \t\t\thello should return 5.
      int currentLength = s.replace("\t", "").length();

      // for root --> simply add its size. Ex: "root" --> just the folder name as input
      if (level == 0) levels[level] = currentLength;
      else { // Adding +1 for "/". Ex: abc/1.txt -->output8. So need to add +1 for "/"
        int parentLength = levels[level - 1];
        levels[level] = 1 + parentLength + currentLength;
      }

      if (s.contains(".")) { // Only for file calculate length
        maxLength = Math.max(levels[level], maxLength);
      }
    }
    return maxLength;
  }
}
