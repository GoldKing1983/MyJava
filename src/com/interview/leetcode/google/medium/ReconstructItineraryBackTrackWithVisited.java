package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

https://leetcode.com/problems/reconstruct-itinerary/

1) Here visited logic is added with map of sourceToDestination as key and value as count of tickets.
2) Because 2 tickets with same "from" and "to" location is valid.
3) This code is better than ReconstructItineraryBackTrack, because we are not doing remove operation on arraylist.
4) Here add/remove operation done on linkedList which is O(1) only.


 */
public class ReconstructItineraryBackTrackWithVisited {
  Map<String, List<String>> adjMap = new HashMap<>();
  Map<String, Integer> visited = new HashMap<>();
  LinkedList<String> path = new LinkedList<>();
  int n = 0;

  public List<String> findItinerary(List<List<String>> tickets) {
    n = tickets.size() + 1;
    for (List<String> ticket : tickets) {
      adjMap.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
      String uniquePath = ticket.get(0) + ticket.get(1);
      visited.put(uniquePath, visited.getOrDefault(uniquePath, 0) + 1);
    }

    for (List<String> neibs : adjMap.values()) Collections.sort(neibs);

    path.add("JFK");
    backTrack("JFK");
    return path;
  }

  public boolean backTrack(String from) {
    if (path.size() == n) return true;
    List<String> connectedCities = adjMap.get(from);
    if (connectedCities == null) return false;
    for (String to : connectedCities) {
      String uniquePath = from + to;
      if (visited.get(uniquePath) == 0) continue;
      visited.put(uniquePath, visited.get(uniquePath) - 1);
      path.add(to);
      if (backTrack(to)) return true;
      path.removeLast();
      visited.put(uniquePath, visited.get(uniquePath) + 1);
    }
    return false;
  }
}
