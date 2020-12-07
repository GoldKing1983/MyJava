package com.interview.leetcode.google.medium;

import java.util.ArrayList;

/*
https://leetcode.com/problems/product-of-the-last-k-numbers/


===============================================================Solution Approach=============================================
1) During the add   ---  If the prefixProductList is empty just add the number.
 					     Else multiply the current number with top number.
2) During the get   ---  If (n==k) return topNumber; //Ex: [1,2,3]. Top will be 6.
 					     If (n<k)  return 0; //Ex: They ask for top3 product. list has only 2 numbers.
					     Else      return (topNumber/ number at (n-k-1))// Ex: [1,2,3]. Top 1 = 6/2=3
3) During the add(0) --- Reset prefixProductList.

==============In Interview Just explain with 1 number that is more than enough==============
======Adding input 1=========
Original input array is : [1]
Product array is : [1]
======Adding input 2=========
Original input array is : [1, 2]
Product array is : [1, 2]
======Adding input 3=========
Original input array is : [1, 2, 3]
Product array is : [1, 2, 6]
======Adding input 4=========
Original input array is : [1, 2, 3, 4]
Product array is : [1, 2, 6, 24]
======Adding input 5=========
Original input array is : [1, 2, 3, 4, 5]
Product array is : [1, 2, 6, 24, 120]
==============Getting Top : 5==============
Element at : 5 is : 120
Total Element : 5
n==k. So return 120 directly
==============Getting Top : 4==============
Element at : 5 is : 120
Element at : 1 is : 1
Result it : 120/1 : 120
==============Getting Top : 3==============
Element at : 5 is : 120
Element at : 2 is : 2
Result it : 120/2 : 60
==============Getting Top : 2==============
Element at : 5 is : 120
Element at : 3 is : 6
Result it : 120/6 : 20
==============Getting Top : 1==============
Element at : 5 is : 120
Element at : 4 is : 24
Result it : 120/24 : 5
==============================================================================================================================
 */
public class ProductOftheLastKNumbers {
  private ArrayList<Integer> prefixProductList;

  public ProductOftheLastKNumbers() {
    prefixProductList = new ArrayList<>();
  }

  public void add(int currentNumber) {
    if (currentNumber > 0) {
      if (prefixProductList.isEmpty()) prefixProductList.add(currentNumber);
      else {
        int lastProduct = prefixProductList.get(prefixProductList.size() - 1);
        prefixProductList.add(lastProduct * currentNumber);
      }
    } else {
      prefixProductList = new ArrayList<>();
    }
  }

  public int getProduct(int k) {
    int n = prefixProductList.size();
    int lastProduct = prefixProductList.get(n - 1);
    if (n < k) return 0; // Not enough elements
    if (n == k) return lastProduct; // Ex: [1,2,3] ==> top3 is 6
    return lastProduct / prefixProductList.get(n - k - 1);
  }
}
