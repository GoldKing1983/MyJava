package com.interview.leetcode.google.hard;

import com.interview.leetcode.linkedin.easy.IsomorphicStrings;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/string-transforms-into-another-string/

Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
Return true if and only if you can transform str1 into str2.

===============================Example=================================================================================
Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.

"aabcc",
"aabee" ==> c changed to e
"aadee" ==> b changed to d
"ccdee" ==> a changed to c

Wrone One...
"aabcc",
"ccbcc" ==> a changed to c
"ccdcc" ==> b changed to d
"eedee" ==> c changed to e
====================================Solution Approach - Initial Thinking===========================================================================
1) If I code as per requirement. Then my logic would be.
	==========================Lets take Sample1==========================
Input: str1 = "aabcc", str2 = "ccdee", output: true
Iteration1) Start from left unique character (i.e) a
"aabcc",
"ccbcc" ==> a changed to c
"ccdcc" ==> b changed to d
"eedee" ==> c changed to e ===> Reached end. Couldn't form output.
Iteration2) Since I cannot form output, i will move to change next unique.(i.e) b
"aabcc",
"aadcc" ==> b changed to d
"aadee" ==> c changed to e
"ccdee" ==> a changed to c ========> I got output now.
   ==========================Lets take Sample2==========================
Input: str1 = "ab", str2 = "ba" Output: true
Iteration1) Start from left unique character (i.e) a
"ab"
"bb" ==> a changed to b
"aa" ==> b changed to a ===> Reached end. Couldn't form output.
Iteration2) Since I cannot form output, i will move to change next unique.(i.e) b
"ab"
"aa" ==> b changed to a
"bb" ==> a changed to b ===> Reached end. Couldn't form output.
	======== One thing is clear even I did "Round-Robin" approach of changing characters. I couldn't able to form output.
	========Point here is I need temp variable. If there is a cycle.========
"ab"
"cb" ==> a changed to c
"ca" ==> b changed to a
"ba" ==> c changed to b========> I got output now.

=============================================Solution Approach - Final=============================================
1) Based on above requirement analysis. I can reduce my code to "isomorphicString" logic with one side, with condition
str1 cannot go over the size of "26"

Example s1="ace", s2="cea", draw arrows between each transformation
====Requirement Solution====scan and change all(from 0 to length of string1) - as per requirement========
key  -> value
a    ->    c ==> cce
c    ->    e ==> eee
e    ->    a ==> aaa

=====Isomerphic code Solution===change only 1 character from left to right================
key  -> value
a    ->    c ==> cce
c    ->    e ==> cee
e    ->    a ==> cea
==============================================================================================================================
	========scan and change all(from 0 to length of string1) - as per requirement========
Wrone One...(Changing 0th character first)
ab
bb ==> a changed to b
aa ==> b changed to a.
So ab cannot be changed to ba.

Wrone One...(Changing 1st character first)
ab
aa ==> b changed to a.
bb ==> a changed to b
So ab cannot be changed to ba.
================================================================================================================
s1="ace", s2="cea", draw arrows between each transformation
key  -> value
a    ->    c
c    ->    e
e    ->    a
If a value shows up later as a key, then it makes a linkedlist structure,
and if a value has already been a key, then there is a cycle (in this case, the last "a" is the key in the first row).

For linkedlist without cycle we can just backward substitute the key with the value, there exists a way of converting s1 to s2 for sure.
For linkedlist with a cycle, such as "a -> c -> e -> a", we need to break the loop and use a temporary variable to cache the point of break,
in this case, it becomes the transformation with two steps: "a -> tmp" and "tmp -> c -> e -> a".
Now the bottleneck is if we can find a temporary variable to carry the conversion, if there is one, then the conversion is viable.
================================================================================================================
1) When there is a cycle, additional temp variable needex. Ex: str1 = "ab", str2 = "ba".
2) So if all 26 characters are used, then there must be a cycle and with 26 result is not possible. So return false.
================================================================================================================
 */
public class StringTransformsIntoAnotherString {
  IsomorphicStrings iso = new IsomorphicStrings();

  public boolean canConvert(String str1, String str2) {
    // If both str1 and str2 are same. Then no logic required.
    if (str1.equals(str2)) return true;

    Set<Character> set = new HashSet<>();
    for (Character c : str2.toCharArray()) set.add(c);
    // If we can convert str1 to str2 then size of str2 must be less than 26.
    if (set.size() == 26) return false;

    // Verify str1 can be converted into str2 by using isomorphic code
    return iso.isMatched(str1, str2);
  }
}
