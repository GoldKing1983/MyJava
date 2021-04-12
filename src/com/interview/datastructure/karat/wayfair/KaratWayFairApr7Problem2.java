package com.interview.datastructure.karat.wayfair;

/*

1) Given a Matrix of N*N that consists of only W(White) and B(Black)
2) Verify whether u can satisfy the condition

input:
      W W W W W ->row1
      B W B B W ->row2
      B B B W B ->row3
      
conditionRow1: {}  -> true... No condition. So true
conditionRow1: {1}  -> false... Because there are no 1 consecutive Black.
conditionRow1: {5}  -> false... Because there are no 5 consecutive Black.

conditionRow2: {1,2}  -> true... 1Black followed by White...2 Black followed by white
conditionRow2: {2,1}  -> true... 2 Black followed by white is available at end 1Black followed by White available at begninning
conditionRow2: {3}    -> false.. Because there are no 3 consecutive Black.

conditionRow3: {3,1}  -> true... 3Black followed by White...1 Black followed by white or nothing
conditionRow3: {2}  -> false... Because there must be White after 2 consecutive White
conditionRow3: {4}  -> false... Because there are no 4 consecutive Black.     
      
 */
public class KaratWayFairApr7Problem2 {
  

}
