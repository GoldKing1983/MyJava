package com.interview.leetcode.topic.string;

/*
 * https://leetcode.com/problems/string-compression/
Almost same problem as CountAndSay

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

=====================================================One-Place where I stuck=====================================================
1) Converting the "currentCharCount" to String is tricky. Ex: "currentCharCount= 123"
2) I can use... String.valueOf(currentCharCount); Integer.toString(currentCharCount);
3) If I code to get value from leftToRight it is difficult. From rightToLeft is Easy(Use / and % logic) 
=====================================================Solution Approach===========================================================
Similar to RunLengthEncoding(RLE). If I used standard RLE then it is not in-place.
1) For each of "currentChar" at location "i", verify  "duplicateCount" from location "i+1".
2) Read currentChar. Mark the "duplicateCount" as 1.
3) In the innerLoop, Increment "currentCharCount" as many times "currentChar" is re-occurring.
4) Add "currentChar" to result.
5) If currentCharCount>1 then add count to result, else don't add... as per requirement.

 */
public class StringCompressionRunLengthEncoding {
  public int compress(char[] chars) {
    int readIndex = 0, writeIndex = 0, n = chars.length;
    while (readIndex < n) {
      int currentCharCount = 1;
      char currentChar = chars[readIndex];
      while (readIndex + 1 < n && currentChar == chars[readIndex + 1]) {
        readIndex++;
        currentCharCount++;
      }
      readIndex++;
      chars[writeIndex++] = currentChar;
      if (currentCharCount == 1) continue;

      String s = String.valueOf(currentCharCount);
      for (char c : s.toCharArray()) chars[writeIndex++] = c;
    }
    return writeIndex;
  }
}
