package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

https://leetcode.com/problems/reconstruct-itinerary/

1) Visited Logic will fail, because of below case.... i.e there can be 2 tickets with same "fromTo" (a---->b twice).
2) But when we remove a path for the visited one like in code "ReconstructItineraryBackTrack". It is perfect solution.

		        			a---->b---->c---->a---->b

 */
public class ReconstructItineraryBackTrackWithVisited {
  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> ans = new ArrayList<>();
    Map<String, List<String>> adjMap = new HashMap<>();
    for (List<String> ticket : tickets)
      adjMap.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));

    for (List<String> neibs : adjMap.values()) Collections.sort(neibs);

    ans.add("JFK");
    backTrack("JFK", adjMap, new HashSet<>(), ans, tickets.size() + 1);
    return ans;
  }

  public boolean backTrack(
      String from,
      Map<String, List<String>> adjMap,
      Set<String> visited,
      List<String> result,
      int total) {
    if (result.size() == total) return true;
    List<String> connectedCities = adjMap.get(from);
    if (connectedCities == null || connectedCities.isEmpty()) return false;
    for (int i = 0; i < connectedCities.size(); i++) {
      String to = connectedCities.get(i);
      String uniquePath = from + to;
      if (visited.contains(uniquePath)) continue;
      visited.add(uniquePath);
      result.add(to);
      if (backTrack(to, adjMap, visited, result, total)) return true;
      result.remove(result.size() - 1);
      visited.remove(uniquePath);
    }
    return false;
  }
}
