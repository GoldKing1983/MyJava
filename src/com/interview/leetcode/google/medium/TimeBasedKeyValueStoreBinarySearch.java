package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/time-based-key-value-store/

Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").


Input: inputs = ["TimeMap","set","get","get","set","get","get"],
inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
Output: [null,null,"bar","bar",null,"bar2","bar2"]
Explanation:
TimeMap timeMap;
timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
timeMap.get("foo", 1);  // output "bar"
timeMap.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2,
				  // then the only value is at timestamp 1 ie "bar"
timeMap.set("foo", "bar2", 4);
timeMap.get("foo", 4); // output "bar2"
timeMap.get("foo", 5); //output "bar2"

=================Solution Approach=================
1) The timestamps for all TimeMap.set operations are strictly increasing. So we can do direct binarySearch without sorting.
2) As per above statement, timestamp cannot be duplicate.
3) So In binary search get the floor value i.e equal or less than targetTimeStemp.

 */
public class TimeBasedKeyValueStoreBinarySearch {
  class TimeAndValue {
    int timestamp;
    String val;

    public TimeAndValue(int timestamp, String val) {
      this.timestamp = timestamp;
      this.val = val;
    }
  }

  Map<String, List<TimeAndValue>> map = new HashMap<>();

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<TimeAndValue>());
    }

    map.get(key).add(new TimeAndValue(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";
    List<TimeAndValue> timeAndValue = map.get(key);
    return binSearchGetFloor(timeAndValue, 0, timeAndValue.size() - 1, timestamp);
  }

  private String binSearchGetFloor(
      List<TimeAndValue> timeAndValue, int low, int high, int targetTimeStamp) {
    // Ex: [10,20] target=9. high will be -1
    if (low > high) return high == -1 ? "" : timeAndValue.get(high).val;
    int mid = low + (high - low) / 2;
    int midTimeStamp = timeAndValue.get(mid).timestamp;
    if (midTimeStamp == targetTimeStamp) return timeAndValue.get(mid).val;
    if (midTimeStamp > targetTimeStamp)
      return binSearchGetFloor(timeAndValue, low, mid - 1, targetTimeStamp);
    return binSearchGetFloor(timeAndValue, mid + 1, high, targetTimeStamp);
  }
}
