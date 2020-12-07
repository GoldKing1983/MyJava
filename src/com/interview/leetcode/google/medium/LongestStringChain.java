package com.interview.leetcode.google.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-string-chain/

Requirement: Given a list of words return longest possible length of a word chain. Chain can start from any word
and can go till end. Input Word can start from 1Char word or 2Char Word or any size.
 Ex: Input: ["hello","hellow"] Output: 2

===================================================Initial Thoughts - Not right Approach==============================
1) Take a word. Insert 'a-z' character on each index. Verify anyOf combo is available.
Ex: Take "hello" as source.
Generate "ahello", verify availability.
Generate "haello", verify availability.
Generate "heallo", verify availability....................
	======Issue: Too many combos are created un-necessarily. Still the logic might work======
====================================================Logical Approach====================================================
1) Take a word. cut a character on each index. Verify anyOf combo is available
Ex: Take "hello" as source.
cutting 0th index. Generate "ello", verify availability.
cutting 1st index. Generate "hllo", verify availability.
cutting 2nd index. Generate "helo", verify availability
cutting 3rd index. Generate "helo", verify availability
cutting 4th index. Generate "hell", verify availability
2) If a combo is available. Take that combo's longestChainString value and add1.
3) Else add 1 to say that, it is parent. Any bigger string can use this. Ex: hellow.
====================================================Solution Approach====================================================
1) Sort the given word by length.
2) Initially assign all the word chain length to 1. Considering all are parent.
3) Take a word. Cut a character. Verify if generated combo available.
4) If a combo is available. Take that combo's longestChainString value and add1.
5) Else don't do anything.
====================================================Data Analysis ====================================================

input : ["a","b","ab","abc","xy","xyz","xzz","xyzz","xyzzz"] Output:4

 				   a(1) b(1)  		  xy(1)
 					 \  /	    		|
 Math.max(1,1)+1=2=> ab(2)       	 xyz(2) xzz(1)
					  |             	\    /
					 abc(3)      		xyzz(3)=Math.max(2,1)+1
					   					  |
					   		  			xyzzz(4)

==========================
Current Word: 'a'
Previous Word: ''
dp: {a=1}
==========================
Current Word: 'b'
Previous Word: ''
dp: {a=1, b=1}
==========================
Current Word: 'ab'
Previous Word: 'b'
Previous Word: 'a'
dp: {a=1, ab=2, b=1}
==========================
Current Word: 'xy'
Previous Word: 'y'
Previous Word: 'x'
dp: {a=1, ab=2, xy=1, b=1}
==========================
Current Word: 'abc'
Previous Word: 'bc'
Previous Word: 'ac'
Previous Word: 'ab'
dp: {a=1, ab=2, xy=1, b=1, abc=3}
==========================
Current Word: 'xyz'
Previous Word: 'yz'
Previous Word: 'xz'
Previous Word: 'xy'
dp: {a=1, ab=2, xy=1, b=1, abc=3, xyz=2}
==========================
Current Word: 'xzz'
Previous Word: 'zz'
Previous Word: 'xz'
Previous Word: 'xz'
dp: {a=1, ab=2, xy=1, b=1, abc=3, xyz=2, xzz=1}
==========================
Current Word: 'xyzz'
Previous Word: 'yzz'
Previous Word: 'xzz'
Previous Word: 'xyz'
Previous Word: 'xyz'
dp: {a=1, ab=2, xy=1, b=1, abc=3, xyz=2, xzz=1, xyzz=3}
==========================
Current Word: 'xyzzz'
Previous Word: 'yzzz'
Previous Word: 'xzzz'
Previous Word: 'xyzz'
Previous Word: 'xyzz'
Previous Word: 'xyzz'
dp: {a=1, ab=2, xy=1, b=1, abc=3, xyz=2, xzz=1, xyzz=3, xyzzz=4}


 */
public class LongestStringChain {
  public int longestStrChain(String[] words) {
    // Sort the given word by length.
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    // Initially set everyone as parent. i.e root itself.
    Map<String, Integer> dp = new HashMap<>();
    for (String word : words) dp.put(word, 1);
    int longestStringChain = 1;
    for (String word : words) {
      for (int i = 0; i < word.length(); ++i) {
        String combo = word.substring(0, i) + word.substring(i + 1);
        if (dp.containsKey(combo)) {
          int currentLongestStringChainForCombo = dp.get(combo) + 1;
          int previousLongestChainForCurrentWord = dp.get(word);
          if (previousLongestChainForCurrentWord < currentLongestStringChainForCombo) {
            dp.put(word, currentLongestStringChainForCombo);
            longestStringChain = Math.max(longestStringChain, currentLongestStringChainForCombo);
          }
        }
      }
    }
    return longestStringChain;
  }
}
