package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.HtmlParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
https://leetcode.com/problems/web-crawler/

Requirement:
1) The  startUrl has child urls, which is obtained by htmlParser.getUrls.
2) If the child urls, starts with same hostname of startUrl then add it to result.
3) child may contain cycle. Avoid them by visited.
4) visited is the final answer.
=======================
How to get hostName:
Ex: startUrl    : http://news.yahoo.com/news/topics/
1) split by "/".
2) result String array will be [http:, , news.yahoo.com, news, topics]
3) At index 2, I will be getting hostName.
4) Add "http://" to index2 to get hostName with http.
========================================================Solution Approach===============================================================
1) Recur for the startUrl
2) For the startUrl and get its child.
3) If the child is not visited and starts with startUrlHostName add it to visited.
4) visited is the result.
 */
public class WebCrawler {
  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    Set<String> visited = new HashSet<>();
    String hostNameWithHttp = "http://" + startUrl.split("/")[2];
    recur(startUrl, htmlParser, hostNameWithHttp, visited);
    return new ArrayList<>(visited);
  }

  private void recur(
      String startUrl, HtmlParser htmlParser, String hostNameWithHttp, Set<String> visited) {
    if (!startUrl.startsWith(hostNameWithHttp) || visited.contains(startUrl)) return;
    visited.add(startUrl);
    for (String url : htmlParser.getUrls(startUrl))
      recur(url, htmlParser, hostNameWithHttp, visited);
  }
}
