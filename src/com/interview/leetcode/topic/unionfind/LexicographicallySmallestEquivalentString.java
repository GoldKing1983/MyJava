package com.interview.leetcode.topic.unionfind;

/*



Input: s1 = "a", s2 = "b", baseStr = "a"
Output: "a"

Input: s1 = "a", s2 = "b", baseStr = "b"
Output: "a"

Input: s1 = "b", s2 = "a", baseStr = "a"
Output: "a"

Input: s1 = "b", s2 = "a", baseStr = "b"
Output: "a"

Input: s1 = "rkr", s2 = "rrs", baseStr = "rsr"
Output: "kkk"


=======================================================Data Flow Analysis========================================================
Input: s1 = "a", s2 = "b", baseStr = "b"
Output: "a"

       0 1 2 3 4 5
root = 0 0
=====
Input: s1 = "bc", 
       s2 = "ca", 
  baseStr = "ca"
    Output= "aa"

       0 1 2 3 4 5
root = 0 0 1
 */
public class LexicographicallySmallestEquivalentString {
  public String smallestEquivalentString(String input1, String input2, String pattern) {
    int[] root = new int[26];
    for (int i = 0; i < 26; i++) root[i] = i;

    for (int i = 0; i < input1.length(); i++) {
      int sourceNodeId = input1.charAt(i) - 'a';
      int targetNodeId = input2.charAt(i) - 'a';

      int sourceNodeGroup = find(root, targetNodeId);
      int targetNodeGroup = find(root, sourceNodeId);

      if (sourceNodeGroup == targetNodeGroup) {
        //root[sourceNodeGroup] = targetNodeGroup;  // both works
        root[targetNodeGroup] = sourceNodeGroup;
      } else if (sourceNodeGroup < targetNodeGroup) { // source is smaller, group "target to source" 
        root[targetNodeGroup] = sourceNodeGroup;
      } else { // targetNodeGroup < sourceNodeGroup 
        root[sourceNodeGroup] = targetNodeGroup; // target is smaller, group "source to target"
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      sb.append((char) ('a' + find(root, c - 'a')));
    }
    return sb.toString();
  }

  public int find(int[] root, int id) {
    while (true) {
      //root[id] = root[root[id]]; // path compression
      if (id == root[id]) return id;
      id = root[id];
    }
  }
}
