package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/*
* https://leetcode.com/problems/construct-binary-tree-from-string/
*
* 1) Read 1st number(root) and push into stack.
* 2) For "(" no operation is needed.
* 3) If it is number, peek and attach new number as node. If peek left is empty, then attach in left. Else right.
* 4) For ")" character, just pop.
* 5) Step 2,3,4 continuous till last character of string.
* 5) It works
*
* 1(2(22))(3(33))
* 					1
* 				2		3
* 			22		  33
*
*Step1:
*			Push 1
*Step1a: "(" ignored
*Step2:
*			Update(Top)
*				 1
* 				2
*
* 			Push 2
*Step2a: "(" ignored
*Step3:
*
* 					 1
* 				    2
*                22
*
* 			Update(Top)	which in turn updates above top also
*				  2
* 				22
*
* 			Push 3
*
*Step4: Top Removed for input ")"
*
* 					 1
* 				    2
*                22
*
* 			Update(Top)
*				  2
* 				22
*
*Step5: Top Removed for input ")"
*
* 					 1
* 				    2
*                22
*
*

*
*/
public class ConstructBinaryTreeFromString {
  public TreeNode str2tree(String s) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    int i = 0;
    StringBuilder number = new StringBuilder();
    if (s.length() == 0) return null;
    // ========================Read the first number and push into stack.============
    while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-'))
      number.append(s.charAt(i++));
    TreeNode currentNode = new TreeNode(Integer.valueOf(number.toString()));
    stack.offer(currentNode);
    // ========================Start Read from 2nd number onwards.============
    while (i < s.length()) {
      if (s.charAt(i) == ')') {
        stack.pop();
        i++;
      } else if (s.charAt(i) != '(') {
        number = new StringBuilder();
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-'))
          number.append(s.charAt(i++));
        currentNode = new TreeNode(Integer.valueOf(number.toString()));
        TreeNode parent = stack.peek();
        if (parent.left != null) parent.right = currentNode;
        else parent.left = currentNode;
        stack.push(currentNode);
      } else i++;
    }
    return stack.isEmpty() ? null : stack.peek();
  }
}
