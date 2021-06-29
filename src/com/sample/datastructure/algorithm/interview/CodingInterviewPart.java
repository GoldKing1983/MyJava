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
==============================================Sorting difference================================================================
If the array has "negative numbers" which ranges from Integer.MIN_VALUE to Integer.MAX_VALUE then   
sort has to be like ==> Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
         instead of ==> Arrays.sort(points, (a, b) -> a[0]- b[0]);

Assume Integer.MIN_VALUE=-5 and Integer.MAX_VALUE=5
Ex: [[-5,-4],[5,6]]... a[0]-b[0]... -5-(5)=-10.... We can see clear overflow, and sorting is unexpected
So don't use a-b to compare when sorting. Use Integer.compare(a,b) instead!!!
==============================================================================================================
                                                     
 */
public class CodingInterviewPart {
}
