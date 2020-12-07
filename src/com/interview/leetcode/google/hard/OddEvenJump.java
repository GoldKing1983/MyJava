package com.interview.leetcode.google.hard;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/odd-even-jump/
https://massivealgorithms.blogspot.com/2019/03/leetcode-975-odd-even-jump.html
================================================================Requirement================================================================
1) You are given an integer array A.
2) From starting index0, you can make a series of jumps.
3) The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.
4) So indexes are not considered for odd/even jumps.
5) For each index consider it as firstJump or OddJump and find whether it can reach end. If Yes increment resultCount.
What is OddJump? It is the firstJump/thirdJump/fifthJump.... for eachIndex.
What is EvenJump? It is the secondJump/fourthJump/sixthJump.... for eachIndex.
	Ex: [1,2,3,4,5]
Iteration1:	Index0 is OddJump. From OddJump frog goes to certain nextPoint based on OddJump condition. So nextPoint is now EvenJump.
Iteration2:	Index1 is OddJump. From OddJump frog goes to certain nextPoint based on OddJump condition. So nextPoint is now EvenJump.
Iteration3:	Index2 is OddJump. From OddJump frog goes to certain nextPoint based on OddJump condition. So nextPoint is now EvenJump.
Iteration4:	Index3 is OddJump. From OddJump frog goes to certain nextPoint based on OddJump condition. So nextPoint is now EvenJump.
Iteration5:	Index4 reached end. resultCount incremented auto.

6) For Odd jump -> the next jump should be firstEqualOrGreater value--> lower to firstEqualOrBig
		Ex: [1,10,20,30,5]
From index0-->1(Odd jump) firstEqualOrBig is 5. So reached end. So index0 is qualified for resultCount.

7) For Even jump -> the next jump should be firstEqualOrLesserValue --> bigger to firstEqualOrLesser
		Ex: [1,10,5,30,3,9,7]
From index0-->1(Odd jump) --> firstEqualOrBig is 5. So it goes to index2.
From index2-->5(Even jump) --> firstEqualOrLesser is 3. So it goes index4.
From index4-->3(Odd jump) --> firstEqualOrBig is 7. So reached end. So index0 is qualified for resultCount.
================================================================================================================================================
In short From Left to Right, first jump should be first >=highest, second jump should be first <=lowest.
================================================================Solution Approach - High Level Thinking==========================================
1) BottomUp DP Approach.
2) For eachOfElement in index fromLast, add it to TreeMap with "number itself as Key" and "index as value".
3) For eachOfElement in index fromLast, verify oddJumpPossible and evenJumpPossible and record its result.
Ex: oddJumpDp[5=true] ..... evenJump[5=false]

4) Reuse the  oddJumpDp and evenJump.
                  Ex1:[4,5]=========Below also explains why TreeMap instead of TreeSet=========
                  a) index1 is calculated for oddJumpDp and evenJump.
                  b) Consider index0 is OddJump and its firstEqualOrBig lands in index1. So answer of index1 is answer of index0.
				  c) Consider index0 is EvenJump and its firstEqualOrLesser is null. So for index0 EvenJump answer is false.

                  Ex2:[5,4]=========Below also explains why TreeMap instead of TreeSet=========
                  a) index1 is calculated for oddJumpDp and evenJump.
                  b) index0 is EvenJump and its firstEqualOrLesser lands in index5. Then answer of index5 is answer of index4

5) By default lastPostion of array is result. oddJumpDp[n - 1] = evenJumpDp[n - 1] = true. Push element to TreeMap with value and index.
Ex: [100] Ans=1.
================================================================Data Flow Analysis================================================================

Input : [5,1,3,4,2] Output : 3
===================Initial value before loop===================
oddJumpDp = [false, false, false, false, true]
evenJumpDp = [false, false, false, false, true]
map = {2=4}
===================Iteration1===================
oddJumpDp = [false, false, false, false, true]
evenJumpDp = [false, false, false, true, true]
map = {2=4, 4=3}
===================Iteration2===================
oddJumpDp = [false, false, true, false, true]
evenJumpDp = [false, false, true, true, true]
map = {2=4, 3=2, 4=3}
===================Iteration3===================
oddJumpDp = [false, true, true, false, true]
evenJumpDp = [false, false, true, true, true]
map = {1=1, 2=4, 3=2, 4=3}
===================Iteration4===================
oddJumpDp = [false, true, true, false, true]
evenJumpDp = [false, false, true, true, true]
map = {1=1, 2=4, 3=2, 4=3, 5=0}
======================================================================================================================================================
 */
public class OddEvenJump {
  public int oddEvenJumps(int[] A) {
    int n = A.length, resultCount = 0;
    boolean[] oddJumpDp = new boolean[n], evenJumpDp = new boolean[n];
    oddJumpDp[n - 1] = evenJumpDp[n - 1] = true;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(A[n - 1], n - 1);
    for (int i = n - 2; i >= 0; --i) {
      Map.Entry<Integer, Integer> oddJumpNextMove = map.ceilingEntry(A[i]);
      Map.Entry<Integer, Integer> evenJumpNextMove = map.floorEntry(A[i]);

      // Note: OddJumpDp Refers EvenJumpDp as its nextMove
      oddJumpDp[i] = oddJumpNextMove == null ? false : evenJumpDp[oddJumpNextMove.getValue()];

      // Note: EvenJumpDp Refers OddJumpDp as its nextMove
      evenJumpDp[i] = evenJumpNextMove == null ? false : oddJumpDp[evenJumpNextMove.getValue()];

      map.put(A[i], i); // Save Current number with its index to map.
    }
    // Pick the result from oddJumpDP. Because for allIndex, initial move is oddJump.
    for (boolean oddJump : oddJumpDp) if (oddJump) resultCount++;
    return resultCount;
  }
}
