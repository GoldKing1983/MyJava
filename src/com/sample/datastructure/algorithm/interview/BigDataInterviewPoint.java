package com.sample.datastructure.algorithm.interview;

/*
1) Considering limited memory in a mobile phone, which data structure you will use for an dictionary of phone directory. 
Operation would be Read, update of phone directory? Options are Binary Tree or HashMap
Answer: Binary Tree. HashMap initializes data with 2,4,8,16,32. Even if data is not there data structure is created. 
Ex: for 33 element 64 object will be created. In case of Binary Tree operations are O(log(n)) but memory consumption is best.

2) Consider a Big File, which has millions of data. How will you sort it?
Don't think of mergeSort. Simple bucket sort will make things work. int[] bucket = new int[256]. Thats it.
 */
public class BigDataInterviewPoint {

}
