package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/design-hashset

Almost Same as DesignHashMap without value.
 */
public class DesignHashSet {
  static class Set {
    private int key;
    private Set next;
  }

  private static final int BUCKET_SIZE = 1000000;
  private Set[] set = new Set[BUCKET_SIZE];

  /*
   * 1) During collision (PUT operation) find will return null.
   * 2) During duplicate it will return node.
   */
  private Set find(final Set entry, final int key) {
    if (entry == null) return null;
    if (entry.key == key) return entry;
    return find(entry.next, key);
  }

  private int getHashKey(final int key) {
    return key % BUCKET_SIZE;
  }

  // if an entry is found for the key, don't do anything. Else create new entry make it as
  // firstEntry. Connect firstEntry.next to previous firstEntry
  public void add(final int key) {
    int hashKey = getHashKey(key);
    Set existingFirstEntry = set[hashKey];
    Set existingEntry = find(existingFirstEntry, key);
    if (existingEntry == null) {
      Set currentFirstEntry = new Set();
      currentFirstEntry.key = key;
      set[hashKey] = currentFirstEntry;
      currentFirstEntry.next = existingFirstEntry;
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public boolean contains(final int key) {
    int hashKey = getHashKey(key);
    Set firstEntry = set[hashKey];
    Set existingEntry = find(firstEntry, key);
    if (existingEntry == null) return false;
    return true;
  }

  public void remove(final int key) {
    int hashKey = getHashKey(key);
    Set firstEntry = set[hashKey];
    if (firstEntry == null) return;
    // remove key found at firstEntry.
    if (firstEntry.key == key) set[hashKey] = firstEntry.next;
    else
      for (Set e = firstEntry; e.next != null; e = e.next)
        if (e.next.key == key) {
          e.next = e.next.next;
          return;
        }
  }
}
