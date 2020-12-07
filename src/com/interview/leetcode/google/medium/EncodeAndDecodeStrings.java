package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/encode-and-decode-strings/

2conversions needed 1) adding special character. 2) If that special character comes in input, so change that to
something special.

1) Tricky.... adding just "#" will not work.
2) adding just "# " will not work.
3) adding just " #" will not work.
4) only " # " will work. Because # is surrounded by spaces. even if input comes with " # " we will turn it to " ## ",
which is separate conversion.

{"abc", "def"}    =>  "abc # def # "
{'abc', '#def'}   =>  "abc # ##def # "
{'abc##', 'def'}  =>  "abc#### # def # "
["abc # ", "def"] =>  "abc ##  # def #"

 */
public class EncodeAndDecodeStrings {
  public String encode(List<String> strs) {
    StringBuilder out = new StringBuilder();
    for (String s : strs) out.append(s.replace("#", "##")).append(" # ");
    return out.toString();
  }

  public List<String> decode(String s) {
    List<String> strs = new ArrayList<>();
    String[] array = s.split(" # ", -1);
    for (int i = 0; i < array.length - 1; ++i) strs.add(array[i].replace("##", "#"));
    return strs;
  }
}
