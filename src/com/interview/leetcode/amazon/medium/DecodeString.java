package com.interview.leetcode.amazon.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *
1) Given an encoded string, return its decoded string.
2) If no number specified before "[". Then it is 0. Ex: [a] = 0[a] = ""
=====================================Example1=====================================
s = "3[a]2[bc]", return "aaabcbc".
step1: a+a+a = aaa
step2:aaa+bc+bc = aaabcbc
=====================================Example2=====================================
s = "3[a2[c]]", return "accaccacc".
step1: c+c = cc
step2: a+cc = acc
step3: acc+acc+acc = accaccacc
=====================================Example3=====================================
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
step1: abc+abc = abcabc
step2: abcabc + cd+cd+cd = abcabccdcdcd
step3: abcabccdcdcd+ef = abcabccdcdcdef
=====================================Example Corner Cases=====================================
s="hello" return "hello"
s="hello[a]" return "hello"
s="hello1[a]" return "helloa"
s=[hello], return ""
s = "3[a[bc[d]]]" return "3a"
s="1[a2[bc1[d]]]" return "abcdbcd"
s="1[a[bc5[d]]]"
=========================================Solution Approach=========================================
0) Use 2 stack "numberStack" and "wordStack".
1) If "character", keep updated "currentWord".
2) If "number" keep update "currentNumber". Ex: 123... 0*10+1=1, 1*10+2=12, 12*10+3=123.
3) If "[", Push "currentWord" to "wordStack". Push "currentNumber" to "numberStack".  Reset "currentWord" and "currentNumber".
4) If "]" then process data from "numberStack" and "wordStack".
   Pop "existingWord" from "wordStack" and "existingNumber" from "numberStack".
   Append "currentWord" to "existingWord"  "existingNumber" of times. Set "currentWord" to "existingWord" which is result.
Note: 0 added in Number, if no number is present before "["
==================================================================================================
Input: "abc" Output: "abc"

currentChar:a numberStack:[] wordStack:[a]
currentChar:b numberStack:[] wordStack:[ab]
currentChar:c numberStack:[] wordStack:[abc]
==================================================================================================
Input: "2[abc]" Output: "abcabc"

currentChar:2 numberStack:[] wordStack:[]
currentChar:[ numberStack:[2] wordStack:[, ]=========> Note Empty word is pushed.
currentChar:a numberStack:[2] wordStack:[a, ]
currentChar:b numberStack:[2] wordStack:[ab, ]
currentChar:c numberStack:[2] wordStack:[abc, ]
currentChar:] numberStack:[] wordStack:[abcabc]
==================================================================================================
Input: "1[ab2[cd]]" Output: "abcdcd"

currentChar:1 numberStack:[] wordStack:[]
currentChar:[ numberStack:[1] wordStack:[, ]
currentChar:a numberStack:[1] wordStack:[a, ]
currentChar:b numberStack:[1] wordStack:[ab, ]
currentChar:2 numberStack:[1] wordStack:[ab, ]
currentChar:[ numberStack:[2, 1] wordStack:[, ab, ]
currentChar:c numberStack:[2, 1] wordStack:[c, ab, ]
currentChar:d numberStack:[2, 1] wordStack:[cd, ab, ]
currentChar:] numberStack:[1] wordStack:[abcdcd, ]
currentChar:] numberStack:[] wordStack:[abcdcd]
==================================================================================================
Input: "1[a[bc2[d]]]" Output: "a"

currentChar:1 numberStack:[] wordStack:[]
currentChar:[ numberStack:[1] wordStack:[, ]
currentChar:a numberStack:[1] wordStack:[a, ]
currentChar:[ numberStack:[0, 1] wordStack:[, a, ]
currentChar:b numberStack:[0, 1] wordStack:[b, a, ]
currentChar:c numberStack:[0, 1] wordStack:[bc, a, ]
currentChar:2 numberStack:[0, 1] wordStack:[bc, a, ]
currentChar:[ numberStack:[2, 0, 1] wordStack:[, bc, a, ]
currentChar:d numberStack:[2, 0, 1] wordStack:[d, bc, a, ]
currentChar:] numberStack:[0, 1] wordStack:[bcdd, a, ]
currentChar:] numberStack:[1] wordStack:[a, ]
currentChar:] numberStack:[] wordStack:[a]
==================================================================================================
Input: "3[a]2[bc]" Output: "aaabcbc"

currentChar:3 numberStack:[] wordStack:[]
currentChar:[ numberStack:[3] wordStack:[, ]
currentChar:a numberStack:[3] wordStack:[a, ]
currentChar:] numberStack:[] wordStack:[aaa]
currentChar:2 numberStack:[] wordStack:[aaa]
currentChar:[ numberStack:[2] wordStack:[, aaa]
currentChar:b numberStack:[2] wordStack:[b, aaa]
currentChar:c numberStack:[2] wordStack:[bc, aaa]
currentChar:] numberStack:[] wordStack:[aaabcbc]
==================================================================================================

 */
public class DecodeString {

  public String decodeString(String s) {
    Deque<Integer> numberStack = new ArrayDeque<>();
    Deque<StringBuilder> wordStack = new ArrayDeque<>();
    StringBuilder currentWord = new StringBuilder();
    int currentNumber = 0;
    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        currentNumber = currentNumber * 10 + ch - '0';
      } else if (ch == '[') {
        numberStack.push(currentNumber);
        wordStack.push(currentWord);
        currentWord = new StringBuilder();
        currentNumber = 0;
      } else if (ch == ']') { // process
        int count = numberStack.pop();
        if (count == 0) {
          currentWord = wordStack.pop();
          continue;
        }
        String currentWordString = currentWord.toString();
        for (int i = 1; i < count; i++) {
          currentWord.append(currentWordString);
        }
        StringBuilder existingWord = wordStack.pop();
        existingWord.append(currentWord);
        currentWord = existingWord;
      } else currentWord.append(ch);
    }
    return currentWord.toString();
  }
}
