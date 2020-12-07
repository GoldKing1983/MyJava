package com.sample.datastructure;

/*
 * Tree image is present in "US Problems" "trie.jpeg"
======================================Trie Theory==================================================================
1) A trie stores words and supports add/search in O(w) time, where w is the length of the word.
2) The number of total words stored in the trie doesn't matter,
3) So looking up the word "apple" requires basically 5 operations regardless of
whether the trie stores 100 words or 1,000,000 words.
4) Benefit using Map is I can save any "Character" apart from Alphabet.
==================================================================================================================
1) There will be an one empty root node initially.
2) There after there will be one children will be added for each character which is not there in parent.

 */
public class ImplementTrieOrPrefixTreeArrayApproach {
  class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean isEnd;
  }

  private TrieNode root = new TrieNode();

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';
      if (temp.arr[index] == null) {
        TrieNode newNode = new TrieNode();
        temp.arr[index] = newNode;
        temp = newNode;
      } else {
        temp = temp.arr[index];
      }
    }
    temp.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';
      if (temp.arr[index] != null) {
        temp = temp.arr[index];
      } else {
        return false;
      }
    }
    return temp.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode temp = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      int index = c - 'a';
      if (temp.arr[index] != null) {
        temp = temp.arr[index];
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ImplementTrieOrPrefixTreeArrayApproach trie = new ImplementTrieOrPrefixTreeArrayApproach();

    trie.insert("test");
    System.out.println("test" + trie.search("test"));
    trie.insert("tess");
    System.out.println("test" + trie.search("test"));
    System.out.println("tess" + trie.search("tess"));
  }
}
