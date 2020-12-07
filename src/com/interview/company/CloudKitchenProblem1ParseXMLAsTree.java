package com.interview.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*

Given an xml as input. Create a tree out of it.
==================Sample XML File - How it is==================
<a>
    <b>
        <c>foo</c>
        <c>foo1</c>
    </b>
    <d> bar </d>
</a>
==================Sample Input XML File==================
Assume for the above XML. A stream service which parses and returns me data by data.


START_TAG:a
    START_TAG:b
        START_TAG:c
            TEXT:foo
        END_TAG:c

        START_TAG:c
            TEXT:foo1
        END_TAG:c
    
    END_TAG:b
    
    START_TAG:d
        TEXT:bar
    END_TAG:d
    
END_TAG:a
END_OF_FILE

==================Solution Approach==================
1) "n-aryTree" with "stack" approach.
2) If currentRow is "START_TAG". 
    2a) create newNode, 
    2b) peek topNode from stack, 
    2c) associate newNode to child of topNode. 
    2d) push newNode to "stack"
3) If currentRow is "TEXT". peek the lastNode update data.
4) If currentRow is "END_TAG". pop topNode from stack. 
 */
public class CloudKitchenProblem1ParseXMLAsTree {
  public static void main(String[] args) {
    CloudKitchenProblem1ParseXMLAsTree c = new CloudKitchenProblem1ParseXMLAsTree();
    c.generateNode();
  }

  class Node {
    String tag="";
    String data="";
    List<Node> child = new ArrayList<>();

    public String toString() {
      return tag + " " + data + " " + child;
    }
  }

  public void generateNode() {
    Deque<Node> stack = new ArrayDeque<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(
        "/Users/thangaprabhuchandrasekhar/projects/MyJava/resources/sampleXmlAsStream")))) {
      Node root = null;
      while (true) {
        String rowData = reader.readLine().trim();
        if(rowData.equals("")) continue;
        System.out.println(rowData);
        
        if (rowData.equals("END_OF_FILE")) break;
        String[] splitString = rowData.split(":");
        String tagName = splitString[0];
        String tagValue = splitString[1];

        if (tagName.equals("START_TAG")) {
          Node node = new Node();
          node.tag = tagValue;
          if (stack.isEmpty()) {
            root = node;
            stack.push(node);
          } else {
            stack.peek().child.add(node);
            stack.push(node);
          }
        } else if (tagName.equals("TEXT")) {
          stack.peek().data = tagValue;
        }

        else if (tagName.equals("END_TAG")) {
          stack.pop();
        }
      }
      System.out.println(root);

    } catch (Exception e) {
      System.out.println("Error Reading File" + e);
    }
  }

}
