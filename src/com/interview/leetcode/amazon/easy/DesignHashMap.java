package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/design-hashmap

https://leetcode.com/problems/design-hashmap/discuss/238843/Separate-Chaining-Java-Solution
====General Theory========
1) The general implementation of HashMap uses bucket which is basically a chain of linked
lists and each node containing <key, value> pair.
2) When we insert the pair (10, 20) and then (10, 30), there is technically no collision involved.
We are just replacing the old value with the new value for a given key 10, since in both cases,
10 is equal to 10 and also the hash code for 10 is always 10.
3) Collision happens when multiple keys hash to the same bucket. In that case,
we need to make sure that we can distinguish between those keys. Chaining collision resolution
is one of those techniques which is used for this.
4) Just for the information. In JDK 8, HashMap has been tweaked so that if keys can be compared for ordering,
then any densely-populated bucket is implemented as a tree, so that even if there are lots of
entries with the same hash-code, the complexity isO(log n).

Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
Space complexity: O(n) - where n is the number of entries in HashMap

========PUT Operation========
1) During the first time. head is null. So create a node and assign it to table[hashKey].
2) During the second time.
		a) If node has collision, then the new node will be chained at first. Map Array size is still 1.
		b) If there is duplicate, then existing node data will be replaced. Map Array size is still 1.
		c) Else node will be entered in new Entry. Map Array size will be 2.
	=========Tricky How Collision works in PUT==========================
		currentFirstEntry.next = existingFirstEntry;
      	map[hashKey] = currentFirstEntry;
		1) Lets say my hashCode always returns 100. All data lands in same bucket due to collision.
		2) During first time existingFirstEntry will be null. So map[100]= "first"
		3) During second time map[hash] will have previous value in step2. So table[100] = "second"->"first"
		4) During third time map[100] = "third"->"second"->"first"
=========REMOVE Operation===========
Case1) If the hashKey is not found. Then data not found. No Operation.
Case2) If the node to be deleted is at first. Then I need to connect the bucket head with 2nd node.
Case3) For rest of the case simply join next with next.next
==========FIND=======
find will be used during PUT and GET to verify node exists or not
===============
 */
public class DesignHashMap {
  class Map {
    int key, value;
    Map next;
  }

  Map[] myMap;

  public DesignHashMap() {
    myMap = new Map[1000000];
  }

  private Map find(Map firstNode, int targetKey) {
    if (firstNode == null) return null;
    if (firstNode.key == targetKey) return firstNode;
    return find(firstNode.next, targetKey);
  }

  private int getHashKey(int key) {
    return key % 1000000;
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hashKey = getHashKey(key);
    Map firstNode = myMap[hashKey];
    if (firstNode == null) {
      Map node = new Map();
      node.key = key;
      node.value = value;
      myMap[hashKey] = node;
    } else {
      Map existingNode = find(firstNode, key);
      if (existingNode == null) { // Key not exist. Collission
        //Add currentNode as firstNode or head.
        Map node = new Map();
        node.key = key;
        node.value = value;
        node.next = firstNode;
        myMap[hashKey] = node;
      } else { // Duplicate
        existingNode.value = value;
      }
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int hashKey = getHashKey(key);
    Map firstNode = myMap[hashKey];
    Map existingNode = find(firstNode, key);
    return existingNode == null ? -1 : existingNode.value;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hashKey = getHashKey(key);
    Map firstNode = myMap[hashKey];
    if (firstNode == null) return;
    if (firstNode.key == key) {
      myMap[hashKey] = firstNode.next;
      return;
    }
    Map prevNode = firstNode;
    Map nextNode = firstNode.next;
    while (nextNode != null) {
      if (nextNode.key == key) {
        prevNode.next = nextNode.next; // skip the nextNode
        return;
      }
      prevNode = nextNode;
      nextNode = nextNode.next;
    }
  }
}
