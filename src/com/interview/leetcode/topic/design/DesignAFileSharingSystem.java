package com.interview.leetcode.topic.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*

1) Use priorityQueue to reuse the id of user who are leaving.
2) 
 */
public class DesignAFileSharingSystem {
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  Map<Integer, Set<Integer>> userToChunks = new HashMap<>();
  int chunkId = 1;

  public int join(List<Integer> ownedChunks) {
    int id = -1;
    if (pq.isEmpty()) id = chunkId++;
    else id = pq.poll();
    userToChunks.put(id, new HashSet<>(ownedChunks));
    return id;
  }

  public DesignAFileSharingSystem(int m) {}

  public void leave(int userID) {
    pq.add(userID);
    userToChunks.remove(userID);
  }

  // return list of users who are keeping the chunkId
  // Iterate each the userToChunk. If the Set<chunk> contains chunkId, add users to result.
  // Finally, if any user has chunk, then add chunk to current user 
  public List<Integer> request(int userID, int chunkID) {
    List<Integer> res = new LinkedList<>();
    for (Map.Entry<Integer, Set<Integer>> userAndChunks : userToChunks.entrySet()) {
      if (userAndChunks.getValue().contains(chunkID)) {
        res.add(userAndChunks.getKey());
      }
    }
    if (!res.isEmpty()) userToChunks.get(userID).add(chunkID);
    return res;
  }
}
