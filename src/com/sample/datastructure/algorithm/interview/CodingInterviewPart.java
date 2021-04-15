package com.sample.datastructure.algorithm.interview;

/*
1) Don't use "+" to concat string. Use StringBuilder for String manipulation.
2) StringBuilder insert is O(n) or costly operation. Because it needs to move(shift) elements using ArrayCopy.
So use append() and do reverse at end.

======================visited logic for dynamic-matrix======================
Option1) Use Set<String>... set.add(row+""+col);
Option2) Use Map<Integer,<Set<Integer>>>.... map.computeIfAbsent(row, v->new HashSet<>()).add(col);
Option3) Hashing... ex: if total rowCol is 300... Then hash= row*300+col
                                                     for 0th row we fill from 0 to 299
                                                     for 1st row we fill from 1 to 599..
==============================================================================================================
                                                     
 */
public class CodingInterviewPart {}
