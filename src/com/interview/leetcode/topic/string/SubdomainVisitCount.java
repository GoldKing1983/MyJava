package com.interview.leetcode.topic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

https://leetcode.com/problems/subdomain-visit-count
===========================================================Requirement===========================================================
1) Given a domain with visitCount. 
2) Return list of domain/subDomain with updated visitCount. 
============================================================Example1=============================================================
Input: ["9001 discuss.leetcode.com"]
Output:  ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
============================================================Example2=============================================================
Input: ["20 mail.yahoo.com", "30 mail.google.com", "40 search.google.com"]
Output:  
      com                       - 20+30+40=90
      google.com                - 30+40=70
      yahoo.com                 - 20
      mail.yahoo.com            - 20
      mail.google.com           - 30
      search.google.com         - 40
      

 */
public class SubdomainVisitCount {

  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> map = new HashMap<>();
    for (String cd : cpdomains) {
      int i = cd.indexOf(' ');
      int visitCount = Integer.parseInt(cd.substring(0, i));
      String domain = cd.substring(i + 1);

      // save domain with visitCount
      map.put(domain, map.getOrDefault(domain, 0) + visitCount);

      // from leftToRight if I see "." then update sub-domain with visitCount. Continue till end
      for (i = 0; i < domain.length(); ++i) {
        if (domain.charAt(i) == '.') {
          String subDomain = domain.substring(i + 1);
          map.put(subDomain, map.getOrDefault(subDomain, 0) + visitCount);
        }
      }
    }

    List<String> res = new ArrayList<>();
    for (String d : map.keySet()) res.add(map.get(d) + " " + d);
    return res;
  }
}
