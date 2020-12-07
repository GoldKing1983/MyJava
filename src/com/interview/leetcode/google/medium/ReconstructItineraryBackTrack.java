package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

https://leetcode.com/problems/reconstruct-itinerary/

==============================================================Requirement===================================================
1) Given a list of airline tickets represented by pairs of from and to.
2) Reconstruct the itinerary such that, "from" is "JFK" and visit all cities.
It is guaranteed that there is a solution all time

Ex1: Invalid Input: Because route ends with "d" and there are 2 paths. If we choose either path, one path will be skipped.
	       	   ---->b---->
		a---->|			  |---->d
			   ---->c---->

Ex2: Valid Input: a->b b->c c->d and d->c
		a---->b---->c---->d
				 |	   	  |
				  ----<---

Ex3:
		a---->b---->c---->d

Ex4:(Note: Valid Input... there can be 2 tickets with same "fromTo" (a---->b twice))
	  a---->b---->c---->a---->b

Graph Theory: In a Directed Graph, given a Source, visit all node and return the path. If there are more than
one path, choose alphabetically lower path.

===========Removal of FromTo once visited is a must because of Ex2 or visited Logic should be added===========
 */
public class ReconstructItineraryBackTrack {
  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> ans = new ArrayList<>();
    Map<String, List<String>> adjMap = new HashMap<>();
    for (List<String> ticket : tickets)
      adjMap.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));

    for (List<String> neibs : adjMap.values()) Collections.sort(neibs);

    ans.add("JFK");
    backTrack("JFK", adjMap, ans, tickets.size() + 1);
    return ans;
  }

  public boolean backTrack(
      String from, Map<String, List<String>> adjMap, List<String> result, int total) {
    if (result.size() == total) return true;
    List<String> connectedCities = adjMap.get(from);
    if (connectedCities == null || connectedCities.isEmpty()) return false;
    for (int i = 0; i < connectedCities.size(); i++) {
      String to = connectedCities.remove(i); // remove visited fromTo
      result.add(to); // add path to result
      if (backTrack(to, adjMap, result, total)) return true;
      result.remove(result.size() - 1); // // remove path from result
      connectedCities.add(i, to); // add back visited fromTo
    }
    return false;
  }
}
