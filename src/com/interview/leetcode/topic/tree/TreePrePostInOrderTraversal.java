package com.interview.leetcode.topic.tree;

import com.interview.leetcode.list.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
*/
public class TreePrePostInOrderTraversal {

  /*
  			    10
  			5        15
  		4      7  13    20
  		Result should be : 10 5 4 7 15 13 20
  */
  public void preOrderTraversalUsingStack() {
    if (root == null) return;
    LinkedList<Node> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node parent = stack.pop();
      if (parent == null) continue;
      System.out.printf("%d ", root.val);
      stack.push(parent.right);
      stack.push(parent.left);
    }
  }

  public void printPreOrderRecurse(Node root) {
    if (root == null) return;
    System.out.printf("%d ", root.val);
    printPreOrderRecurse(root.left);
    printPreOrderRecurse(root.right);
  }

  /*
   * Slight modification from pre-order with stack.
   * Instead of printing, push it to list. and print in reverse finally.
   */
  public void printPostOrderUsingStack(Node root) {
    Deque<Node> stack = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node n = stack.pop();
      list.add(n.val);
      if (n.left != null) {
        stack.push(n.left);
      }
      if (n.right != null) {
        stack.push(n.right);
      }
    }
    // Print all elements of second stack
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.print(list.get(i) + " ");
    }
  }

  public void printPostOrderRecurse(Node root) {
    if (root != null) {
      printPostOrderRecurse(root.left);
      printPostOrderRecurse(root.right);
      // Visit the node by Printing the node data
      System.out.printf("%d ", root.val);
    }
  }

  public void printInOrderRecurse(Node root) {
    if (root != null) {
      printInOrderRecurse(root.left);
      // Visit the node by Printing the node data
      System.out.println(root.val + " " + root.left + " " + root.right);
      printInOrderRecurse(root.right);
    }
  }

  public void printInOrderStack(Node root) {
    Deque<Node> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      System.out.print(root.val + " ");
      root = root.right;
    }
  }

  /*
   * 				  10
   *           5 		   20
   *        4     6	15	   30
   */

  private Node root;

  public void add(int data) {
    Node tempRoot = root;
    Node currNode = new Node();
    currNode.val = data;
    if (tempRoot == null) {
      root = currNode;
    } else {
      while (true) {
        if (data < tempRoot.val) {
          if (tempRoot.left != null) {
            tempRoot = tempRoot.left;
          } else {
            tempRoot.left = currNode;
            break;
          }
        } else {
          if (tempRoot.right != null) {
            tempRoot = tempRoot.right;
          } else {
            tempRoot.right = currNode;
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    TreePrePostInOrderTraversal p = new TreePrePostInOrderTraversal();
    p.add(10);
    p.add(5);
    p.add(4);
    p.add(6);
    p.add(20);
    p.add(30);
    p.add(15);
    //		p.add(21);
    //		p.add(22);
    System.out.println("=====printPreOrderRecurse====");
    p.printPreOrderRecurse(p.root);
    System.out.println();
    System.out.println("=====printPreOrderUsingStack====");
    p.preOrderTraversalUsingStack();
    System.out.println();
    System.out.println("=====printPostOrderUsingRecurse====");
    p.printPostOrderRecurse(p.root);

    System.out.println("\n=====printPostOrderUsingStack====");
    p.printPostOrderUsingStack(p.root);
    System.out.println();
    System.out.println("=====printInOrderRecurse====");
    p.printInOrderRecurse(p.root);
    System.out.println("\n=====printInOrderUsingStack====");
    p.printInOrderStack(p.root);
  }
}
