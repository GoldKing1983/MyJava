package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/reconstruct-itinerary/
==============================================================Requirement===================================================
1) Given a list of airline tickets represented by pairs of from and to.
2) Reconstruct the itinerary such that, "from" is "JFK" and visit all cities.
It is guaranteed that there is a solution all time, meaning there will be a path in input to visit all nodes.

Ex1: Invalid Input: Because route ends with "d" and there are 2 paths. If we choose either path, one path will be skipped.
	       	   ---->b---->
		a---->|			  |---->d
			   ---->c---->

Ex2: Valid Input: a->b b->c c->d and d->c Ans: a->b->c->d->c
		a---->b---->c---->d
				 |	   	  |
				  ----<---

Ex3:
		a---->b---->c---->d

Ex4:(Note: Valid Input... there can be 2 tickets with same "fromTo" (a---->b twice))
	  a---->b---->c---->a---->b

Ex5: In-Valid Input a->b, a->c, c->b, b->d... We miss path a->b to a->c anytime
	       	   ---->-->-->b---->d
		a---->|	 	 |
			   ---->c

Ex6: Valid Input a->b, a->c, c->b, b->d, d->a... Ans: a->b->d->a->c
	       	   ---->-->-->b---->d---
		a---->|	 	 |				|
		|	   ---->c               |
		 ------<-------<---------<--

Graph Theory: In a Directed Graph, given a Source, visit all node and return the path. If there are more than
one path, choose alphabetically lower path.

========================================================Solution Note================================================
Just Eulerian path. Greedy DFS, building the route backwards when path ends(i.e when no child).

1) This solution pushes the dead-end node to first by doing "res.addFirst(s)" which is a post-order traversal.
2) It is possible only because of condition "there must exist an itenary of all tickets
===================================================Data Flow Analysis================================================
Ex6: Valid Input a->b, a->c, c->b, b->d, d->a... Ans: a->b->d->a->c->b
	       	   ---->-->-->b---->d---
		a---->|	 	 |				|
		|	   ---->c               |
		 ------<-------<---------<--

    from a traverse starts goes all the way to  a->b->d->a->c->b.. Traverse stops at b.

	for b -> Only child "d" is polled already. So it is dead-end now,  So b added to result in first. path=[b]
	for c -> Only child "b" is polled already. So it is dead-end now,  So c added to result in first. path=[c,b]
	for a -> child "b and c" is polled already. So it is dead-end now,  So a added to result in first. path=[a,c,b]
	for d -> Only child "a" is polled already. So it is dead-end now,  So d added to result in first. path=[d,a,c,b]
	for b -> Only child "d" is polled already. So it is dead-end now,  So b added to result in first. path=[b,d,a,c,b]
	for a -> child "b and c" is polled already. So it is dead-end now,  So a added to result in first. path=[a,b,d,a,c,b]
===================================================Solution Alternate - BackTrack=================================
1) Once we find dead-end or unable to visit all nodes. Select alternate option.
2) With bacTrack we can go with next combination. But that code is too much
 */
public class ReconstructItinerary {
  HashMap<String, PriorityQueue<String>> adjMap = new HashMap<>();
  LinkedList<String> path = new LinkedList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> ticket : tickets)
      adjMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));

    dfs("JFK");
    return path;
  }

  // Ex: [a->b] ans:[a,b].
  // Iteration1: fromCity is a, a has child b. So Else will be executed.
  // Iteration2: fromCity is b, b has no child. So If will be executed. b added to result. path=[b]
  // Iteration3: Iteration1 loop ends. a added to result. path=[a,b]
  public void dfs(String fromCity) {
    PriorityQueue<String> toCities = adjMap.get(fromCity);

    if (toCities == null) path.addFirst(fromCity);
    else {
      while (!toCities.isEmpty()) dfs(toCities.poll());
      path.addFirst(fromCity);
    }
  }
}
