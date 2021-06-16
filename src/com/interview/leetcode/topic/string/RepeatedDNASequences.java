package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/repeated-dna-sequences/description/
===========================================================Requirement===========================================================
1) Given a string s that represents a DNA sequence, 
2) Return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
============================================================Example1=============================================================
input: "AAAAAAAAAAA"
output: 2
========================================================Solution Approach========================================================
1) Cache each of 10character word into set.
2) If it is found again, add it to result.

Solution:
1) It is based on sliding window of size 10.
2) Save each window of size 10 in Set. Compare from window 11. 
3) If a match found put in set to avoid duplicate result.   

 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seen = new HashSet<>();
    Set<String> result = new HashSet<>();

    for (int i = 10; i <= s.length(); i++) {
      String tenCharWord = s.substring(i - 10, i);
      if (!seen.add(tenCharWord)) result.add(tenCharWord);
    }

    return new ArrayList<>(result);

  }

}
