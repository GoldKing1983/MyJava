package com.sample.tricky;

import java.util.HashMap;

/*
https://leetcode.com/problems/lru-cache/
Understanding LRU vs LFU "https://xuri.me/2016/08/13/lru-and-lfu-cache-algorithms.html"
https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
=======================================================Requirement===============================================================
Design LRU Cache such that get and put should be in O(1). See picture "LRU-HowItWorks.png"
=====================================================High Level Idea=============================================================
1) Keep new data(when adding/updating data or when an element is accessed) at head.
2) When put is happening and not enough space, remove tail. Add new element to head
3) When get is happening move data from anywhere to head. Connect previous and next of data.
========================================================Tactics==================================================================
1) Reason why doubly linked list selected is, during removal operation, get that node. join previous with next.
Which makes the operation 0(1). If Single linked list is selected. Then entire list has to be traversed for removal operation O(n).
=====================================================Solution Approach===========================================================
			===========put===========See picture "LRUCache.png"
1) add the newNode to head always.
2) if key exists
           option1 :  delete exisitingNode and create newNode at head. 
           option2 :  delete exisitingNode. move the exisitingNode to head. (Below code follow this approach )
3) if key don't exists, create node.
	  a) if LRU is full, remove tail, add the node to head.
   b) Else create node, add it the head.
4) put the node to map.
			===========get===========
1) Whenever data is accessed, move(remove from current and move) that to head.
So, that old data will always present in tail and we can delete tail during LRU is full during put operation.
2) if key is present  do above
3) else -1.
=================================================================================================================================
 *
 */
public class LRUCache {
  class DLLNode {
    // key is useful in 1case only. To remove the "key from map" during lastNode removal at lineNo101.  
    int key;
    int value;
    DLLNode prevNode;
    DLLNode nextNode;

    public DLLNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  int capacity;
  HashMap<Integer, DLLNode> map = new HashMap<>();
  DLLNode head = null; // useful for doing insertion of firstNode at O(1)
  DLLNode tail = null; // useful for doing removal of lastNode at O(1)

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DLLNode n = map.get(key);
      remove(n);
      setHead(n);
      return n.value;
    }

    return -1;
  }

  private void remove(DLLNode currNode) {
    // connect previous with next.
    if (currNode.prevNode != null) {
      currNode.prevNode.nextNode = currNode.nextNode;
    } else {
      head = currNode.nextNode;
    }
    // connect next with previous.
    if (currNode.nextNode != null) {
      currNode.nextNode.prevNode = currNode.prevNode;
    } else {
      tail = currNode.prevNode;
    }
  }

  private void setHead(DLLNode newNode) {
    newNode.nextNode = head;
    newNode.prevNode = null;

    if (head != null) head.prevNode = newNode;

    head = newNode;

    if (tail == null) tail = head;
  }

  public void put(int key, int value) {
    DLLNode exisitingNode = map.get(key);
    if (exisitingNode == null) {
      DLLNode newNode = new DLLNode(key, value);
      if (map.size() == capacity) {//map reached the maximum capacity
        map.remove(tail.key);
        remove(tail);
        setHead(newNode);
      } else {
        setHead(newNode);
      }
      map.put(key, newNode);
    } else {
      exisitingNode.value = value;
      remove(exisitingNode);
      setHead(exisitingNode);
    }
  }
}
