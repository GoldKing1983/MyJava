package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.interview.leetcode.Node;
/*
https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/


Ex: [1,3,2,4,5,6]
                1 
                |
       _________ _________
      |         |         |
      3         2         4
     / \        
    5   6
        
serializedString = [1, 3, 3, 2, 5, 0, 6, 0, 2, 0, 4, 0]

        
1) serializedString saved as "nodeData" followed by "countOfChildren"        
2) No need to maintain "#" for nullNode. Because we represent nullNode by countOfChildren as 0.         

*/

public class SerializeAndDeserializeNAryTreePreOrder {

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    List<String> list = new LinkedList<>();
    serialize(root, list);
    return String.join(",", list);
  }

  private void serialize(Node root, List<String> list) {
    if (root == null) return;

    list.add(String.valueOf(root.val));
    list.add(String.valueOf(root.children.size()));
    for (Node child : root.children) {
      serialize(child, list);
    }
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.isEmpty()) return null;

    String[] serializedString = data.split(",");
    return deserialize(serializedString);
  }

  int index = 0;

  private Node deserialize(String[] serializedString) {
    // No Base Condition is needed. Because we traverse the exact number of times.
    Node root = new Node(Integer.parseInt(serializedString[index++]));
    int size = Integer.parseInt(serializedString[index++]);
    root.children = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      Node deSerializedNode = deserialize(serializedString);
      root.children.add(deSerializedNode);
    }
    return root;
  }
}
