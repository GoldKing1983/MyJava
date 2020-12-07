package com.interview.leetcode.facebook.medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/accounts-merge/

1) Each List contains "name" and "multiple emailIds" where 0th index is name and from 1st index emailIds
2) Same mail id registered in 2 entry needs to be merged.
3) If mail id matches then name will match. No need to think on this.
========================================Example1==========================================================
					 name1
					/  |  \
				  id1 id2 id3

				 	 name2
					/  |  \
				  id4 id5 id6

				 	 name1
					/  |  \
				  id2 id7 id8

				 	 name2
					/     \
				  id9     id10
In above example. "name1" and "name1" needs merge,   because id2 is  common in both.
				  "name2" and "name2" needs no merge because nothing common in both.
========================================Invalid Example======================================================
				 	 name3
					/     \
				  id4     id11

With Example1 above addition is not possible. Because id4 is associated with name2 in Example1.
But here it is name3.
========================================Solution Approach======================================================
1) Create adjMap of email Address.

2) Connect email Address by current and previous.
Ex: If there are 3 email Ids. Start from 2nd mail id.
								Then connect id1-->id2.. id2-->id1
								 	 connect id2-->id3.. id3-->id2

The connection should be like below. But that will create too many space and TimeLimitException. So we stick to above

						   		   ----->id2
                         id1----->|
 						   		   ------id3
						   		   ----->id1
                         id2----->|
 						   		   ------id3
						   		   ----->id1
                         id3----->|
 						   		   ------id2
3) When step 2 is done. 90% of job is done. All email-ids are grouped(think of UnionFind).
4) Now I need to associate, name with it.
5) From the accounts. Take the email name and any-one(first or random) email. Do DFS to collect all grouped emails.
Sort the emails as per requirement.
==============================================Data Flow Analysis=============================================
1) Lets take take example1.
2) When name1 is called with id1 or id2 or id2. DFS will return "id1,id2,id3,id7,id8".
3) When name2 is called with id4 or id5 or id6. DFS will return "id4,id5,id6".
4) When name1 is called with id2 or id7 or id8. All 3 nodes are visited. So DFS itself not called.
5) When name2 is called with id9 or id10. DFS will return "id9,id10".
6) Associate name with DFSResult, whenever DFS is called.
=============================================================================================================

 *
 */
public class AccountsMergeGraphDFS {
  private Map<String, Set<String>> adjMap = new LinkedHashMap<>(); // <email node, neighbor nodes>
  private Set<String> visited = new HashSet<>();
  private List<List<String>> result = new LinkedList<>();

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    buildadjMap(accounts);

    for (List<String> account : accounts) {
      List<String> mergedMail = new LinkedList<>();
      String name = account.get(0);
      String email = account.get(1);
      if (visited.add(email)) {
        dfs(email, mergedMail);
        Collections.sort(mergedMail);
        mergedMail.add(0, name);
        result.add(mergedMail);
      }
    }
    return result;
  }

  public void dfs(String email, List<String> mergedMail) {
    mergedMail.add(email);
    for (String next : adjMap.get(email)) {
      if (!visited.contains(next)) {
        visited.add(next);
        dfs(next, mergedMail);
      }
    }
  }

  /*
  Ex: [a,a@m.com] 			==> adjMap = [[a@m.com,[]]]
  Ex: [a,a@m.com, b@m.com]  ==> adjMap = [[a@m.com,[b@m.com]],[b@m.com, [a@m.com]]]
   */
  private void buildadjMap(List<List<String>> accounts) {
    for (List<String> account : accounts) {
      adjMap.putIfAbsent(account.get(1), new HashSet<>());
      // If there is only one email id, no link needs to be made.
      for (int i = 2; i < account.size(); i++) {
        if (!adjMap.containsKey(account.get(i))) adjMap.put(account.get(i), new HashSet<>());
        adjMap.get(account.get(i)).add(account.get(i - 1));
        adjMap.get(account.get(i - 1)).add(account.get(i));
      }
    }
  }
}
