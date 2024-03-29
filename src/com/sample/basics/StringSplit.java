package com.sample.basics;

import java.util.Arrays;
import org.apache.commons.lang.StringUtils;

/*

1) split keeps the beginWord space. But ignores the endWord space.
Ex: " a " ==> result=["","a"]

2) split needs to be like "\\." or "\\+", if we need to split by special character.  
 */
public class StringSplit {
  public static void main(String[] args) {
    String s = "10.12 USD";
    String[] split = s.split(" ");
    System.out.println(split[0] + "answer");
    System.out.println(split[1] + "answer");

    String s1 = "https://s3.amazonaws.com/store-catalog-import.qa.lumcs.com/ys-50071731-2/"
        + "ys-50071731-2_catalog_import_2e78a5c37cf04255aceddaed8fa7fded";
    System.out.println(s1.substring(s1.lastIndexOf('/') + 1, s1.length()));

    String s3 = " 1  3 ";
    String s3Split[] = s3.trim().replace("  ", " ").split(" ");
    for (int i = 0; i < s3Split.length; i++) {
      System.out.println(s3Split[i]);
    }


    String array[] = {" String", "Tom Selleck ", " Fish "};
    array = StringUtils.stripAll(array);
    System.out.println(Arrays.toString(array));


    String input = "contentLanguage + targetCountry";
    String output[] = input.split("\\+");
    for (String print : output) {
      System.out.println(print.trim());
    }

    input = "https://s3.amazonaws.com/store-catalog-import.qa.lumcs.com/storeId/fileName";
    output = input.split("/");
    for (String print : output) {
      System.out.println(print.trim());
    }
    System.out.println(output[output.length - 1]);

  }
}
