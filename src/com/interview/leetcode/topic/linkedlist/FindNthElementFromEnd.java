package com.interview.leetcode.topic.linkedlist;

/*

    10->20->30->40->50->60->70->80->90->100
    
    n=4... Return 70
    

=====Solution Logic====
1) Take 2 pointers p1 and p2. 

2) Move p1 to n times. Ex: p1 moves to 40.
  
3) Move both p1 and p2 till p1 reaches null.
      Ex: p1 moves to null. p2 stands in 60.

4) return p1.next
 */
public class FindNthElementFromEnd {

}
