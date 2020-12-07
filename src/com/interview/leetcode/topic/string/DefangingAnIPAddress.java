package com.interview.leetcode.topic.string;


/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


 */
public class DefangingAnIPAddress {
  public String defangIPaddr(String address) {
    StringBuilder str = new StringBuilder();
    for (char c : address.toCharArray()) {
      if (Character.isDigit(c)) {
        str.append(c);
      } else {
        str.append("[.]");
      }
    }
    return str.toString();
  }
}
