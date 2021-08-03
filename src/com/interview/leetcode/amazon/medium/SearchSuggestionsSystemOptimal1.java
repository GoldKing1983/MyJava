package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
https://leetcode.com/problems/search-suggestions-system/

Requirement: For the given list of "products", find top3 products in lexicographical order that matches the "searchWord"s
each character's like auto-complete or auto-suggest.

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],  ==> matches "m"
["mobile","moneypot","monitor"],  ==> matches "mo"
["mouse","mousepad"],			  ==> matches "mou"
["mouse","mousepad"],			  ==> matches "mous"
["mouse","mousepad"]			  ==> matches "mouse"
]
==========================================Solution Approach========================================================
1) Instead of Building TRIE, I can build prefixMap and put all products prefix and their full product.

{m=[monitor, mobile, moneypot], mo=[monitor, mobile, moneypot], mob=[mobile],
mobi=[mobile], mobil=[mobile], mobile=[mobile], mon=[monitor, moneypot],
mone=[moneypot], money=[moneypot], moneyp=[moneypot], moneypo=[moneypot],
moneypot=[moneypot], moni=[monitor], monit=[monitor], monito=[monitor],
monitor=[monitor], mou=[mousepad, mouse], mous=[mousepad, mouse], mouse=[mousepad, mouse],
mousep=[mousepad], mousepa=[mousepad], mousepad=[mousepad]}



*/
public class SearchSuggestionsSystemOptimal1 {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    Map<String, TreeSet<String>> prefixMap = new HashMap<>();
    for (String product : products) {
      for (int i = 1; i <= product.length(); i++) {
        String str = product.substring(0, i);
        prefixMap.putIfAbsent(str, new TreeSet<>());
        TreeSet<String> set = prefixMap.get(str);
        set.add(product);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (int i = 1; i <= searchWord.length(); i++) {
      String searchString = searchWord.substring(0, i);
      TreeSet<String> set = prefixMap.get(searchString);
      List<String> top3Result = new ArrayList<>();
      if (set != null) {
        int count = 0;
        for (String data : set) {
          top3Result.add(data);
          count++;
          if (count == 3) break;
        }
      }
      result.add(top3Result);
    }
    return result;
  }
}
