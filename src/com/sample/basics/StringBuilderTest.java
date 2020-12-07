package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

/*
1) StringBuilder is mutable. So it is good for append operation.
2) StringBuilder does not override Object's .equals() method. So equals operation never works.
So StringBuilder to string and do equals
3) StringBuilder accepts only String in constructor. If char or number then it is empty.
*/
public class StringBuilderTest {

  public static void main(String[] args) {
    StringBuilder sb1 = new StringBuilder("abc");
    StringBuilder sb2 = new StringBuilder("abc");
    sb2.insert(0, 'c');
    System.out.println("Insert At 0" + sb2.toString());
    Map<String, String> map = new HashMap<>();
    map.put(sb1.toString(), "1");
    map.put(sb2.toString(), "1");
    System.out.println(map.size());

    System.out.println("StrinBuilder equal fail always " + sb1.equals(sb2));
    System.out.println("StrinBuilder converted to String " + sb1.toString().equals(sb2.toString()));

    System.out.println(sb1.delete(sb1.length() - 1, sb1.length()));
    stringBuilderConstructorTest();
  }

  private static void stringBuilderConstructorTest() {
    System.out.println("======ConstructorTest Start======");
    StringBuilder sb1 = new StringBuilder('a');
    StringBuilder sb2 = new StringBuilder(123);
    StringBuilder sb3 = new StringBuilder("a");
    System.out.println("Value of sb1:'" + sb1.toString() + "'");
    System.out.println("Value of sb2:'" + sb2.toString() + "'");
    System.out.println("Value of sb2:'" + sb3.toString() + "'");
    System.out.println("======ConstructorTest Finished======");
  }
}
