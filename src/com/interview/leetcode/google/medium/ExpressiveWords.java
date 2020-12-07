package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/expressive-words/

Requirement:
1) Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".
	For Each char compare.
      if (targetCount == dictWordCount) continue;
      if (targetCount < dictWordCount) return false;
      if (targetCount < 3) return false;

Input :  target = "heeellooo" words = ["hello", "hi", "helo"]
Output: 1 (only "hello" can be transformed)
Explanation:
"hello" --> true --> We can extend "e" and "o" to get "heeellooo".
"hi" --> false --> when comparing "i" with "e" it fails.
helo --> false --> "l" cannot be transformed to "ll", because transform is accepted only for 3 or more chars only.

=================================Solution Approach==Run Length Encoding=====================================================
1) For the "word" and "target", calculate the "Run Length Encoding".
2) What is "Run Length Encoding"? for "abbcccddddaaaaa", RLE keeps "key" as "abcda", and the "count" as [1,2,3,4,5].
3) For each of "wordRLE" compare targetRLE
3.1) if targetRLE size != wordRLE size. Then false. Ex:"helo" "helo1".
3.2) if (targetRLE.key[i] != wordRLE.key[i]) Then false. Ex: "helo" "Helo"
3.3) else below 3 step... (variables ...targetCount = targetRLECount, dictWordCount =  wordRLECount.)
If targetCount < dictWordCount, then we can't make the ith group of word equal to the ith word of S by adding characters.
If targetCount >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.
Else, if targetCount < 3, then we must have dictWordCount == targetCount for the ith groups of word and S to match.
 */
public class ExpressiveWords {
  public int expressiveWords(String target, String[] words) {
    RunLengthEncoding targetRLE = new RunLengthEncoding(target);
    int ans = 0;
    for (String word : words) {
      RunLengthEncoding wordRLE = new RunLengthEncoding(word);
      if (isMatch(wordRLE, targetRLE)) ans++;
    }
    return ans;
  }

  private boolean isMatch(RunLengthEncoding wordRLE, RunLengthEncoding targetRLE) {
    if (targetRLE.size != wordRLE.size) return false;
    for (int i = 0; i < targetRLE.size; ++i) {
      if (targetRLE.key[i] != wordRLE.key[i]) return false;
      int targetWordCount = targetRLE.count[i];
      int dictWordCount = wordRLE.count[i];
      if (targetWordCount == dictWordCount) continue;
      if (targetWordCount < dictWordCount) return false;
      if (targetWordCount < 3) return false;
    }
    return true;
  }

  class RunLengthEncoding {
    char[] key = new char[100];
    int[] count = new int[100];
    int size = 0; // array is fixed. So to set the "max size" of "key" and "count", size is used

    public RunLengthEncoding(String word) {
      key[0] = word.charAt(0);
      count[0] = 1;
      int left = 0;
      for (int right = 1; right < word.length(); right++) {
        if (word.charAt(right - 1) == word.charAt(right)) count[left]++;
        else {
          left++;
          key[left] = word.charAt(right);
          count[left] = 1;
        }
      }
      size = left + 1;
    }
  }
}
