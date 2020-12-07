package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
See picture "LFU-HowItWorks.png"

=================================Need for LFU=================================
Imagine an asset cache on a CDN, where the assets are cached based on the usage patterns.
So, when users request some images for the web page they are requesting, this CDN will add
it to its cache for other users to get it even faster.
So when capacity is full. "LeastFrequentlyUsed" asset will be removed rather than "LeastRecentlyUsed".
Because  LRU asset may be "most frequently used asset", so cannot remove it.
===================================================================================================

Understanding LRU vs LFU "https://xuri.me/2016/08/13/lru-and-lfu-cache-algorithms.html"
*/
public class LFUCache {
  static class Entry {
    // this is for faster usage. I could be avoided too. Ex: If freq=1 remove instant
    int freq = 1;
    int value;

    public Entry(int val) {
      value = val;
    }
  }

  int size;
  Map<Integer, Entry> map; // stores key: <value, frequency of key>

  // stores sets of keys grouped by their frequencies.
  // because multiple keys can have same frequency. In that case use ordering and remove lowest.
  Map<Integer, LinkedHashSet<Integer>> frequency;

  int minFreq = 1; // keeps track of current least frequent element in map

  public LFUCache(int capacity) {
    size = capacity;
    map = new HashMap<>();
    frequency = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Entry result = map.get(key);
      // increment minimum frequency by 1 if no key is called less than minFreq times.
      if (minFreq == result.freq && frequency.get(result.freq).size() == 1) minFreq++;
      result.freq++;
      setFrequencyForKey(result.freq, key); // increment frequency for key
      return result.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (size == 0) return;

    if (map.containsKey(key)) {
      map.get(key).value = value;
      get(key);
    } else {
      Entry w = new Entry(value);
      if (map.size() == size) {
        // get the least frequent and recent key
        int lrkey = frequency.get(minFreq).iterator().next();
        frequency.get(minFreq).remove(lrkey); // remove least frequent and recent key
        map.remove(lrkey);
      }
      minFreq = 1; // reset minimum frequency to 1 when a new key is added
      map.put(key, w);
      setFrequencyForKey(w.freq, key);
    }
  }

  private void setFrequencyForKey(int freq, int key) { // increment frequency by 1 for 'key'
    if (!frequency.containsKey(freq)) {
      frequency.put(freq, new LinkedHashSet<>());
    }
    if (freq != 1 && frequency.get(freq - 1).contains(key)) {
      frequency.get(freq - 1).remove(key);
    }
    frequency.get(freq).add(key);
  }
}
