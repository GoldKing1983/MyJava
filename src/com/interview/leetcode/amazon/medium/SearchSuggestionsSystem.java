package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.com/problems/search-suggestions-system/

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
==========================================Simple Solution========================================================
1) Sort the product.
2) For each of search word ex: "m", "mo", "mou", "mous", "mouse" search in "sortedProduct".
2a) Below code "traverse" (not binary search) from index0 to indexN-1 for the "searchKey".
2b) So worst case for each "searchKey" entire array is traversed (not searched).
So for a 5 character word, with 1000 products. Complexity of code is O(n(log(n)) + (searchKeyCount * noOfProducts))
===========================================Optimal Solution===========================================
1) Build Trie and minimize search.
2) Sort the product. Do binary search.
*/
public class SearchSuggestionsSystem {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    List<String> top3Result = new LinkedList<>();
    List<List<String>> result = new ArrayList<>();
    for (int i = 1; i <= searchWord.length(); i++) {
      String searchString = searchWord.substring(0, i);
      for (String product : products) {
        if (product.startsWith(searchString)) {
          top3Result.add(product);
          if (top3Result.size() == 3) break;
        }
      }
      result.add(new ArrayList<>(top3Result));
      top3Result.clear();
    }
    return result;
  }
}
