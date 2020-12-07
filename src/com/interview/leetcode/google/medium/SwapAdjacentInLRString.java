package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/swap-adjacent-in-lr-string/

1) Given 2 string "start" and "end", that contains only 'X','R','L' character,
"start" string can be replaced.

This transformation of is one-way i.e only for start
==============================================================================================================================
"XL" can change to "LX",
X moves from LeftToRight or forward
L moves from RightToLeft or backward

"RX" can change to "XR"
R moves from LeftToRight or forward
X moves from RightToLeft or backward.
========Finally X can move both the direction, L can move only backward and R can move only forward.

==============================================================================================================================
start = "XXRXXLXXXX"
end   = "XXXXRXXLXX"
Output: false.

On Seeing 'start' and 'end'.
'R' can traverse forward, so no issue with 'R'.
'L' can traverse only backwards, so 'start' cannot be transformed to 'end'. So result is false.
==============================================================================================================================
"XXXXXLXXXX"
"LXXXXXXXXX"
Output: True

start = "XXXXXLXXXX"
			 ==
step1 = "XXXXLXXXXX"
            ==
step2 = "XXLXXXXXXX"
           ==
step3 = "XLXXXXXXXX"
          ==
step4 = "LXXXXXXXXX"
         ==
end   = "LXXXXXXXXX"
=========================================Solution Approach=2Pointer Approach========================================================================================
Solution is more about understanding "problem cases" and adding multiple conditions.
1) Both size of start and end should be same.

2) If I Ignore 'X' in 'start' and 'end', contents of 'start' and 'end' should be same.
i.e the index on 'L' and 'R' in 'start' and 'end' may vary. But must be in same order or sequence.
Ex: start= 'XLRX'  -- LR 
	end  = 'XRLX'  -- RL..  return false.
	
Ex: start= 'RXXL' end= 'LXXR' return false.

3) Now remaining part is verifying 'L' 'startIndex>=endIndex' and 'R' 'startIndex <= endIndex'. Else False.
Ex: start= 'XLX' end= 'XLX' return true.
Ex: start= 'XXL' end= 'XLX' return true.
Ex: start= 'RXX' end= 'XRX' return true.

====================================================================================================================================================================
 */
public class SwapAdjacentInLRString {
  public boolean canTransform(String start, String end) {
    if (start.length() != end.length()) return false;
    if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
    // For Loop with no condition, like while(true). Because 'loop', always decide true or false.
    for (int startIndex = 0, endIndex = 0; ; startIndex++, endIndex++) {
      // get the non-X positions of 2 strings
      while (startIndex < start.length() && start.charAt(startIndex) == 'X') startIndex++;
      while (endIndex < end.length() && end.charAt(endIndex) == 'X') endIndex++;

      if (startIndex == start.length() || endIndex == end.length()) return true;

      if (start.charAt(startIndex) == 'L') {
        if (startIndex >= endIndex) {
          // 'L' can move only backward. Ex: if start=XXL end=LXX. Continue.
          continue;
        }
        return false; // 'L' can move only backward. So if start=LXX end=XXL. Return false.
      }
      if (start.charAt(startIndex) == 'R') {
        if (startIndex <= endIndex) {
          // 'R' can move only forward. Ex: if start=RXX end=XXR. Continue.
          continue;
        }
        return false; // 'R' can move only forward. So if start=XXR end=RXX. Return false.
      }
    }
  }
}
