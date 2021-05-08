package com.interview.leetcode.topic.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*

https://leetcode.com/problems/encode-and-decode-tinyurl/
===========================================================Requirement===========================================================
Design a fixedLengthEncoding similar to tinyURL.
========================================================Logical Thinking=========================================================
1) 8^62(lowerCase+upperCase+digits) approximately equal to 10^30...
Calucating by 10 is easy to visualize in millions/billions/billionBillion
   
   ex: 8^3 = 8*8*8= 512 ... 10^3= 10*10*10=1000
   I can relate every 3 is half of 10...
    
2) this combination can create billions of billions URL which can hold for 100+years like IP-v4..
========================================================Solution Approach========================================================
1) Randomly generate 8character tinyURL using Random.
2) If the tinyURL is already used, generate again.
3) Store the tinyURL with actualURL in cache, so that we can send back the actualURL.
==========================================================Deep Thinking==========================================================
1) If we call the encode method 2 times with same URL, we might get different tinyURL both times.
2) So we can say encoding is non-idempontent.
==================================================Scalable Design Thinking=======================================================
1) generate - unUsedId and keep in db or cache...Ex: Based on daily usage, keep 10000 - tinyUrl in cache... 


 */
public class EncodeAndDecodeTinyURL {
  String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  Map<String, String> cache = new HashMap<>();
  Random rand = new Random();

  public String getRand() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      sb.append(alphabet.charAt(rand.nextInt(62)));
    }
    return sb.toString();
  }

  public String encode(String longUrl) {
    String tinyURLKey = getRand();
    while (cache.containsKey(tinyURLKey)) {
      tinyURLKey = getRand();
    }
    cache.put(tinyURLKey, longUrl);
    return "http://tinyurl.com/" + tinyURLKey;
  }

  public String decode(String shortUrl) {
    return cache.get(shortUrl.replace("http://tinyurl.com/", ""));
  }

}
