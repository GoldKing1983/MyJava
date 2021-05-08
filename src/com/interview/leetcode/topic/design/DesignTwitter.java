package com.interview.leetcode.topic.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
https://leetcode.com/problems/design-twitter/
===========================================================Requirement===========================================================
1) User can post a tweet. User available or not verification not needed. Should be like idempotent operation.
2) User can follow/unfollow another user. User available or not verification not needed. Should be like idempotent operation.
3) Retrieve the 10 most recent tweet ids in the user's news feed. Tweets can be from follower or by the user itself. 
4) Top10 Tweets must be ordered from most recent to least recent.
========================================================Solution Approach========================================================
1) for every user maintain linkedlist of 10 tweet. Remove the firstTweet if tweet reaches more than 10.
2) Assume user1 -> user2 -> user3... we dont't bother about user1-> user3.. So DFS is not needed. 
It is about direct link only. We care only user1 -> user2
3) To get top10, we push all the followerTweet and selfTweet to PriorityQueue and we fetch top10. 
========================================================Solution Approach2=======================================================
1) I could have managed 1 priorityQueue for all tweets. But it is worst, because fetch logic of userA needs to go through 
every tweets even the tweet not related to userA.
2) Above approach is also worst, because it pushes all tweets to pQ. The ideal approach should pick top10 like mergesort.
Because we save data in sortedOrder by time.   
 */
public class DesignTwitter {
  class Tweet {
    int tweetId;
    int timestamp; // it is the global Id which manages time

    public Tweet(int tweetId, int timestamp) {
      this.tweetId = tweetId;
      this.timestamp = timestamp;
    }
  }

  int timestamp = 0;

  class User {
    int id;
    // user who I follow
    Set<Integer> followers = new HashSet<>();
    LinkedList<Tweet> tweets = new LinkedList<>();

    public void addTweet(int tweetId, int timestamp) {
      tweets.add(new Tweet(tweetId, timestamp));
      if (tweets.size() > 10) tweets.removeFirst(); // remove old tweet from that user
    }
  }

  Map<Integer, User> users = new HashMap<>();

  public DesignTwitter() {

  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    User user = users.get(userId);
    if (user == null) {
      user = new User();
      user.id = userId;
    }
    user.addTweet(tweetId, timestamp++);
    users.put(userId, user);

  }


  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    User user = users.get(userId);
    if (user == null) return result;

    PriorityQueue<Tweet> pQ = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
    // aggregation part
    for (int follower : user.followers) {
      User followerUser = users.get(follower);
      if (followerUser == null) continue;
      LinkedList<Tweet> followerTweets = followerUser.tweets;
      for (Tweet tweet : followerTweets) {
        pQ.offer(tweet);
        if (pQ.size() > 10) pQ.poll();
      }
    }

    for (Tweet tweet : user.tweets) {// Self tweet can also be added to result
      pQ.offer(tweet);
      if (pQ.size() > 10) pQ.poll();
    }

    while (!pQ.isEmpty()) result.add(pQ.poll().tweetId);
    Collections.reverse(result);
    return result;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    User user = users.get(followerId);
    if (user == null) {
      user = new User();
      user.followers.add(followeeId);
      users.put(followerId, user);
    } else {
      user.followers.add(followeeId);
    }

  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    User user = users.get(followerId);
    if (user == null) return;
    user.followers.remove(followeeId);
  }
}
