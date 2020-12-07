package com.interview.leetcode.challenge;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/*

Asked by DoorDash on Oct2-2020

Given n, Generate valid Permutation of PickUp and Delivery.
Condition: Delivery is not possible before pickup. 

Input : n=2. 
Output: 

                          ""
                  /              \
                 P1                P2
                 /  \            /    \
                D1  P2          D2    P1
               /   /  \         /    /  \
              P2  D2  D1       P1   D1   D2  
             /    /     \      /    /     \
            D2   D1     D2    D1   D2      D1

[]
[P1]
[P1, D1]
[P1, D1, P2]
[P1, D1, P2, D2]
[P1, P2]
[P1, P2, D1]
[P1, P2, D1, D2]
[P1, P2, D2]
[P1, P2, D2, D1]
[P2]
[P2, P1]
[P2, P1, D1]
[P2, P1, D1, D2]
[P2, P1, D2]
[P2, P1, D2, D1]
[P2, D2]
[P2, D2, P1]
[P2, D2, P1, D1]
[[P1, D1, P2, D2], [P1, P2, D1, D2], [P1, P2, D2, D1], [P2, P1, D1, D2], [P2, P1, D2, D1], [P2, D2, P1, D1]]


========================================================Solution Approach========================================================
1) Do the permutation logic.
2) Add the condition, if "P" don't exists for a "D" skip that permute and further.
3) BackTracking is must  
 */
public class PermutationWithCondition {

  public static void main(String[] args) {
    PermutationWithCondition p = new PermutationWithCondition();
    p.getCombo(2);
  }

  private List<String> generatePickUpAndDrop(int n) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add("P" + i);
      list.add("D" + i);
    }
    return list;
  }

  public List<LinkedHashSet<String>> getCombo(int n) {
    List<String> input = generatePickUpAndDrop(n);
    List<LinkedHashSet<String>> result = new ArrayList<>();
    permute(input, result, new LinkedHashSet<>(), n);
    System.out.println(result);
    return result;

  }

  private void permute(List<String> input, List<LinkedHashSet<String>> result,
      LinkedHashSet<String> currResult, int n) {
    System.out.println(currResult);
    if (currResult.size() == n * 2) {
      result.add(new LinkedHashSet<>(currResult));
      return;
    }
    for (int i = 0; i < input.size(); i++) {
      String current = input.get(i); // could be pickup or delivery

      if (currResult.contains(current)) continue; // skip duplicate

      else if (current.startsWith("D")) { // If current is delivery then pickup must exist
        String pickUp = "P" + current.charAt(1);
        if (!currResult.contains(pickUp)) continue;
        currResult.add(current);
        permute(input, result, currResult, n);
        currResult.remove(current);
      } else {
        currResult.add(current);
        permute(input, result, currResult, n);
        currResult.remove(current);
      }
    }
  }
}
