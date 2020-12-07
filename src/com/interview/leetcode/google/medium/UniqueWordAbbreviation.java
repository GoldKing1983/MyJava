package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/unique-word-abbreviation/

Requirement:
1) If the abbreviation is taken by a dictionary. Only same can be verified at runtime.
	Ex: lead --> l2d...
	lead comes as query. Then true
	leed comes as query. Then false

2) If the abbreviation is not taken by a dictionary. Return true.
	Ex: Dictionary is empty.
	lead comes as query. Then true
	leed comes as query. Then true

3) If there is more than one string belong to a same "abbr" comes in dictionary,
then the key will be invalid. Add that "abbr" to invalidAbbr.
	Ex: [lead, leed]  --> l2d is abbr for both--> now, no one can use l2d. add l2d to invalidAbbr.
	lead comes as query. Then false
	leed comes as query. Then false
	laad comes as query. Then false

4) For word with size <3 always true.

==========================================Solution Approach==========================================
Code for the requirement. all about understanding requirement.
Purpose is to discuss requirement with interviewer.
 */
public class UniqueWordAbbreviation {
  private Map<String, String> words = new HashMap<>();
  private Set<String> invalidAbbr = new HashSet<>();

  public UniqueWordAbbreviation(String[] dictionary) {
    for (String word : dictionary) {
      if (word.length() < 3) continue;
      String abbr = getAbbreviation(word);
      if (invalidAbbr.contains(abbr)) {
        // don't do anything.
      } else if (words.containsKey(abbr)) {
        // If "abbr" word comes 2nd time. Then remove that from words and add to invalidAbbr.
        // From 3rd time onwards "invalidAbbr" will take care in if condition.
        words.remove(abbr);
        invalidAbbr.add(abbr);
      } else {
        words.put(abbr, word);
      }
    }
  }

  private String getAbbreviation(final String word) {
    char start = word.charAt(0);
    char end = word.charAt(word.length() - 1);
    int size = word.length() - 2;
    // Note: To convert number to valid String...Integer.toString is required.
    return start + Integer.toString(size) + end;
  }

  public boolean isUnique(String word) {
    if (word.length() < 3) return true; // Any word less than size 3 return true as per requirement
    String abbr = getAbbreviation(word);
    if (invalidAbbr.contains(abbr)) return false;
    if (!words.containsKey(abbr)) return true;
    return word.equals(words.get(abbr));
  }
}
