package com.interview.leetcode.topic.game;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/the-maze-iii/

Spent enough time to solve it.
Understand Maze2 that is more than enough

1 important point is direction. Direction is not same as X,Y Co-ordinates.
Ex: {-1,0} from {0,0} point is view is left. Because X is reduced by 1.
But adding this to matrix is "UP" direction.
Ex: in a matrix at point {3,3}.. if {-1,0} added it will be {2,0} which will move to "UP"

 */
public class TheMazeIII {
  // ========================={  u  } ,{  d }, {  r }, {  l  }
  int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  Map<Integer, Character> dir = new HashMap<>();

  {
    dir.put(0, 'u');
    dir.put(1, 'd');
    dir.put(2, 'r');
    dir.put(3, 'l');
  }
}
