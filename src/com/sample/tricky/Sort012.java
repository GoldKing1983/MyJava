package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * See SortColors
 */
public class Sort012 {

  public static void main(String[] args) {
    //List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 3, 2, 1, 2, 3));
    List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 2));
    Integer low = 0;
    Integer high = input.size() - 1;
    Integer mid = 0;
    while (mid <= high) {
      Integer data = input.get(mid);
      switch (data) {
        case 1:
          Collections.swap(input, low++, mid++);
          break;
        case 2:
          mid++;
          break;
        case 3:
          Collections.swap(input, mid, high--);
          break;
      }
    }
    System.out.println(input);
  }
}
