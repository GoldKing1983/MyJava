package com.sample.datastructure;

/*


1) Iterate from Array, Use LinkedList to save result.
2) Reason for LinkedList is, it re-arranges when elements inserted at middle.
3) Finally copy from LinkedList to array.
==========Solution Approach======
Note: Use Binary-Search to find the rightIndex where currentNumber can be inserted.

Ex: [5,20,15]

1) Read 5 from array, linkedList = 5 -> null
2) Read 20 from array, linkedList = 5 -> 20
3) Read 15 from array, linkedList = 5 -> 15 -> 20

where to insert ==> if current lies between prev and next insert. 
 */
public class InsertionSort {

  public static void main(String[] args) {}
}
