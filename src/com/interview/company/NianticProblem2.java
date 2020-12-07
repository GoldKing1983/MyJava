package com.interview.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

Verify whether given points make a loop


      N
      
W    x(0,0)     E

      S


          

input: {'N', 'W', 'S', 'E'} ==> output: true

  Go Up, Go Left, Go Down, Go Right ==> point is same as where it started. So loop. So return true.
      0,0 + -1,0 = -1,0
      -1,0+ 0,-1 = -1,-1
      -1,-1 + 1,0 = 0,-1
      0,-1 + 0,1 = 0,0 


  N       E    S      W
{-1,0} {0,1} {1,0}  {0,-1}


//We can describe a path using a sequence of compass directions. For example, WNNNE
//represents the path formed by taking one step West, three steps North, and one step East.
//
//Our initial goal is to code the following method:
//
//Given a path (i.e., an array consisting of the characters 'N', 'S', 'E', and 'W') return a
//boolean indicating whether or not the path intersects itself.
//
//Examples:
//1. {'N', 'W', 'S', 'E'} returns true.
//2. {'S', 'S', 'W', 'W', 'N'} returns false.

*/


public class NianticProblem2 {

  public static void main(String[] args) {

    MAP_DIRECTIONS.put('N', new int[] {-1, 0});
    MAP_DIRECTIONS.put('E', new int[] {0, 1});
    MAP_DIRECTIONS.put('S', new int[] {1, 0});
    MAP_DIRECTIONS.put('W', new int[] {0, -1});

    char[] input1 = new char[] {'N', 'W', 'S', 'E'};
    char[] input2 = new char[] {'S', 'S', 'W', 'W', 'N'};
    System.out.println(recur(input1));
    System.out.println(recur(input2));
  }

  private static final Map<Character, int[]> MAP_DIRECTIONS = new HashMap<>();

  private static boolean recur(final char[] dirInput) {

    Set<String> visited = new HashSet<>();
    int[] start = new int[] {0, 0};
    visited.add(0 + "" + 0);

    for (char direction : dirInput) {

      int[] valueOfDir = MAP_DIRECTIONS.get(direction);

      int nextRow = start[0] + valueOfDir[0];
      int nextCol = start[1] + valueOfDir[1];
      String nextPoint = nextRow + "" + nextCol;
      if (visited.contains(nextPoint)) return true;
      visited.add(nextPoint);
      start = new int[] {nextRow, nextCol}; // update current location
    }
    return false;
  }

}
