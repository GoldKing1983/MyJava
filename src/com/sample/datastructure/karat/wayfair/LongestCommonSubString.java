package com.sample.datastructure.karat.wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

We have some clickstream data that we gathered on our client's website. Using cookies,
we collected snippets of users' anonymized URL histories while they browsed the site.
The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:(duplicates not possible in array)

user0 = ["start", "green", "blue", "pink", "register", "orange", "one/two"]
user1 = ["start", "pink", "register", "orange", "red", "a"]
user2 = ["a", "one", "two"]
user3 = ["pink", "orange", "yellow", "plum", "blue", "tan", "red", "amber", "HotRodPink", "CornflowerBlue", "LightGoldenRodYellow", "BritishRacingGreen"]
user4 = ["pink", "orange", "amber", "BritishRacingGreen", "plum", "blue", "tan", "red", "lavender", "HotRodPink", "CornflowerBlue", "LightGoldenRodYellow"]
user5 = ["a"]

Sample output:

findContiguousHistory(user0, user1) => ["pink", "register", "orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["plum", "blue", "tan", "red"]
findContiguousHistory(user4, user3) => ["plum", "blue", "tan", "red"]

n: length of the first user's browsing history
m: length of the second user's browsing history

*/
public class LongestCommonSubString {
  public static void main(String[] argv) {

    String[] user0 = {"start", "green", "blue", "pink", "register", "orange", "one/two"};
    String[] user1 = {"start", "pink", "register", "orange", "red", "a"};
    String[] user2 = {"a", "one", "two"};
    String[] user3 = {
      "pink",
      "orange",
      "yellow",
      "plum",
      "blue",
      "tan",
      "red",
      "amber",
      "HotRodPink",
      "CornflowerBlue",
      "LightGoldenRodYellow",
      "BritishRacingGreen"
    };
    String[] user4 = {
      "pink",
      "orange",
      "amber",
      "BritishRacingGreen",
      "plum",
      "blue",
      "tan",
      "red",
      "lavender",
      "HotRodPink",
      "CornflowerBlue",
      "LightGoldenRodYellow"
    };
    String[] user5 = {"a"};
    System.out.println(Arrays.toString(findContiguousHistory(user0, user1)));
    System.out.println(Arrays.toString(findContiguousHistory(user0, user2)));
    System.out.println(Arrays.toString(findContiguousHistory(user2, user1)));
    System.out.println(Arrays.toString(findContiguousHistory(user5, user2)));
    System.out.println(Arrays.toString(findContiguousHistory(user3, user4)));
    System.out.println(Arrays.toString(findContiguousHistory(user4, user3)));
  }

  // user 0 -- a b c d
  // user 1 -- a b c d

  // user 0 -- b c d
  // user 1 -- a b c d
  private static String[] findContiguousHistory(String[] input1, String[] input2) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < input1.length; i++) {
      String currentWord = input1[i];
      int temp = i;
      List<String> currResult = new ArrayList<>(); // a
      for (int j = 0; j < input2.length; j++) {
        if (input2[j].equals(currentWord)) {
          currResult.add(input2[j]);
          i++;
          if (i == input1.length) i = 0;
          currentWord = input1[i];
        }
      }
      i = temp;
      if (currResult.size() > result.size()) result = new ArrayList<>(currResult);
    }
    return result.toArray(new String[] {});
  }
}

// Your previous work is preserved below:
//
// * Hello, world!
// * This is a fully functional Markdown environment.
//
