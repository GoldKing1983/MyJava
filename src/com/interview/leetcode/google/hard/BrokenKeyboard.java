package com.interview.leetcode.google.hard;

/*
https://leetcode.com/discuss/interview-experience/778039/google-phone-interview-rejected

There is a broken keyboard in which space gets typed when you type the letter 'e'.
Given an input string which is the output from the keyboard.
A dictionary of possible words is also provided as an input parameter of the method.
Return a list of possible actual input typed by the user.

Example Input: String: "can s r n " Dictionary: ["can", "canes", "serene", "rene", "sam"]
Expected Output: ["can serene", "canes rene"]

==============================================Solution Approach==============================================
1) We can take https://leetcode.com/problems/add-and-search-word-data-structure-design/ as a base for solving above.
2) Whenever we encounter "space", it can be treated as ' ' and 'e'. Search TRIE for both options.
3) So whenever a specific combo found. Ex: "can", Spin DFS or BFS with "remaining word" and "current word" should still go on.
4) Of-course I feel it is not solvable in 45min. So I don't want to try this weird complex solution.

Also similar to WordBreak
 */
public class BrokenKeyboard {}
