package com.interview.leetcode.topic.array;

/*
 * https://leetcode.com/problems/multiply-strings/

Aim Of Problem: If 2 BigNumbers are given in String, I cannot multiply them due to "NumberOutOfBoundException".
So multiply atmost 1digit at a time. Save in array. Return the result.

==========================================Approach1============================================================================
1) Take both String convert into number, do multiplication.
2) You will get "NumberOutOfBoundException"
==========================================Approach2============================================================================
1) Convert any 1 string to number. Keep 2nd as String.
2) Conversion of 1 string to number itself will throw "NumberOutOfBoundException".
==========================================Approach3============================================================================
This problem test our coding skill. No logic or magic in problem.
1) Just usual School Math.
2) Process each number from rightToLeft, multiply each number. Save it in array from rightToLeft
3) Watch-out result positions.
 * See Image "MultiplyStrings.jpg"
Ex:
		123
		 45
		===
		 15(5*3)
		10 (5*2)
	   05  (5*1)
	   =====
		615
		12 (4*3)
	   08  (4*2)
	  04   (4*1)
	  =====
	   5535
	  =====

=======================================POS Array value for above input=======================================
                5*3     = [0, 0, 0, 1, 5]
                5*2     = [0, 0, 1, 1, 5]
		 		5*1     = [0, 0, 6, 1, 5]
		 		 
		 		4*3     = [0, 0, 7, 3, 5] 
		 		4*2     = [0, 0, 7, 3, 5] 
		 		4*1     = [0, 5, 5, 3, 5]  
		 		
PreviousResult + 4*123  = [0, 5, 5, 3, 5]

 */
public class MultiplyStrings {
  public String multiply(String num1, String num2) {

    int n1 = num1.length(), n2 = num2.length(); // Atmost result can go upto n1+n2 size.

    if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0"; // If anyone number is 0. Result is 0.

    int[] result = new int[n1 + n2];
    for (int num1Pos = n1 - 1; num1Pos >= 0; num1Pos--) {
      int num1Digit = (num1.charAt(num1Pos) - '0');
      for (int num2Pos = n2 - 1; num2Pos >= 0; num2Pos--) {
        int num2Digit = (num2.charAt(num2Pos) - '0');

        int currentMultiplication = num1Digit * num2Digit;

        /*
               123 --> pos = 0,1,2
                45 --> pos = 0,1
                totalPos = 5
                
                multiply 5*3... 15....5 should go in pos4 and 1 should go in pos3
                                      num1Pos = 2 
                                      num2Pos = 1  
                                      lastPos = num1Pos+num2Pos+1 = 4      ===> save 5 in pos4
                                      lastButPrevPos = num1Pos+num2Pos = 3 ===> save 1 in pos3
         */
        int lastPos = num1Pos + num2Pos + 1, lastButPrevPos = num1Pos + num2Pos;

        /*
                61 ==> previousAnswer
               25  ==> currentMultiplication
               ==
         total=31
         result[lastPos] = 1, result[lastButPrevPos] = 3
         */
        int total = currentMultiplication + result[lastPos];

        result[lastButPrevPos] += total / 10;
        result[lastPos] = (total) % 10;
      }
    }
    // "0" at beginning is not accepted. So move index till valid number.
    int posIndex = 0;
    while (result[posIndex] == 0) posIndex++;

    // From pos array copy to String result
    StringBuilder sb = new StringBuilder();
    for (int i = posIndex; i < result.length; i++) sb.append(result[i]);
    return sb.toString();
  }
}
