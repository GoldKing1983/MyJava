package com.interview.leetcode.topic.game;

/*
https://leetcode.com/problems/design-snake-game/

Below is not a fully completed code
Add queue logic, if the snake hits by itself in loop or spirally.

 */
public class DesignSnakeGame {
    int maxRow, maxCol, currentRow = 0, currentCol = 0, foodId, totalFood;
    int[][] food;
    public DesignSnakeGame(int width, int height, int[][] food) {
        maxRow = height;
        maxCol = width;
        this.food = food;
        totalFood = food.length;
    }

    int snakeSize = 0;
    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch(direction) {
            case "U" :
                currentRow--;
                break;
            case "L" :
                currentCol--;
                break;
            case "R" :
                currentCol++;
                break;
            case "D" :
                currentRow++;
                break;
        }
        if(currentRow == maxRow || currentCol == maxCol || currentRow<0 || currentCol<0) return -1;

        if(foodId == totalFood) return  snakeSize;
        int[] currentFoodLocation = food[foodId];

        if(currentFoodLocation[0]==currentRow && currentFoodLocation[1]==currentCol) {
            snakeSize++;
            foodId++;
        }
        return snakeSize;



    }
}
