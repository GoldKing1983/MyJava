package com.interview.leetcode.topic.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/path-crossing/
===========================================================Requirement===========================================================
1) Given a various direction of NEWS.
2) Verify whether any path visited again. If yes return true. Else false.
========================================================Solution Approach========================================================
1) Save each visited direction in matrix. 
2) If the direction comes again, return true.
3) But we cannot statically form matrix as we don't know how long max or min directions can go.
4) Form matrix with map.... "Map<Integer, Set<Integer>>  visitedDirectionMatrix"
    key represents the row. value represents the column.
    
 Ex: input: "NEWS"
                 
      
Initial Position :                   visitedDirectionMatrix[0,0] 
    N or up      : 0, 0 + N = -1,0 : visitedDirectionMatrix[0,0][-1,0]    
    E or right   : -1,0 + E = -1,1 : visitedDirectionMatrix[0,0][-1,0,1]
    W or left    : -1,1 + W = -1,0 : visitedDirectionMatrix contains this already return true.
      
      
      
 */
public class PathCrossing {

  public boolean isPathCrossing(String path) {
    int row = 0, col = 0;
    Map<Integer, Set<Integer>> visitedDirectionMatrix = new HashMap<>();
    visitedDirectionMatrix.computeIfAbsent(0, v -> new HashSet<>()).add(0);
    for (char c : path.toCharArray()) {
      switch (c) {
        case 'N':
          row--;
          break;
        case 'E':
          col++;
          break;
        case 'W':
          col--;
          break;
        case 'S':
          row++;
          break;
      }
      if (visitedDirectionMatrix.containsKey(row) && visitedDirectionMatrix.get(row).contains(col))
        return true;
      visitedDirectionMatrix.computeIfAbsent(row, v -> new HashSet<>()).add(col);
    }
    return false;

  }
}
