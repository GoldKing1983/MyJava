import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
com.interview.leetcode.topic.

===========================================================Requirement===========================================================
=========================================================Initial Thought=========================================================
=================================================Initial Thought - Wrong Approach================================================
=================================================Initial Thought - Right Approach================================================
===========================================================BruteForce============================================================
============================================================Example1=============================================================
=========================================================InvalidExample==========================================================
========================================================Solution Approach========================================================
=================================================Solution Approach - Not Optimal=================================================
=======================================================Data Flow Analysis========================================================
========================================================Logical Thinking=========================================================
=========================================================Time Complexity=========================================================
========================================================Space Complexity=========================================================
===========================================================Corner Case===========================================================
==========================================================Deep Thinking==========================================================
=================================================================================================================================
 */
public class Sample {

  public static List<Integer> loadBalancing(int k, List<Integer> arrival, List<Integer> load) {
    PriorityQueue<Long[]> pQ = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0])); // Sort by arrivalTime
    
    //Store the arrival and its corresponding load in a pair in an ascending order.
    PriorityQueue<int[]> arrivalAndLoadMinHeap = new PriorityQueue<>((arr1, arr2) -> {
      return arr1[0] - arr2[0]; //sorting ascending on basis of arrival
    });

    //Populate the arrivalAndLoad heap. Arrival and Load size are the same
    for (int i = 0; i < arrival.size(); i++) {
      int[] arr = new int[2];
      arr[0] = arrival.get(i);
      arr[1] = load.get(i);

      arrivalAndLoadMinHeap.add(arr);
    }

    //Most Important formula: finish = arrival + load - 1

    //This heap will help with the round robin effect needed.
    PriorityQueue<int[]> finishTimeAndServerMinHeap = new PriorityQueue<>((arr1, arr2) -> {
      return arr1[0] - arr2[0]; //sorted based on earliest finish time.
    });

    int heavyServerLoad = Integer.MIN_VALUE;
    //first allocate the 'k' servers
    for (int i = 0; i < k; i++) {
      int[] arr = arrivalAndLoadMinHeap.poll();
      int server = i + 1;
      int finishTime = arr[0] + arr[1] - 1; //arrival + load - 1
      int loadTime = arr[1];
      heavyServerLoad = Math.max(heavyServerLoad, loadTime);
      //This heap will hold the [lastest finish time, server, load handled by the server]
      finishTimeAndServerMinHeap.add(new int[] {finishTime, server, loadTime});
    }

    //Server availability will be maintained in such a fashion that which ever server gets free first
    //will be allocated to the incoming arrival. Server availability will be of size 'k' provided.
    //Server availability is an array of = [finish time, server].
    //Comparison made with the arrival time.

    while (!arrivalAndLoadMinHeap.isEmpty()) {
      int[] arr = arrivalAndLoadMinHeap.poll();
      int arrivalTime = arr[0];
      //polled array object from the arrivalAndLoadMinHeap.
      int loadTime = arr[1];

      if (arrivalTime < finishTimeAndServerMinHeap.peek()[0]) continue; //arrival time dropped
      else {
        int[] earliestAvailability = finishTimeAndServerMinHeap.poll();
        int updatedFinishTime = arrivalTime + loadTime - 1;
        //replace the old finish time with the new one
        earliestAvailability[0] = updatedFinishTime;
        //update the load handled by the server
        earliestAvailability[2] += loadTime;
        heavyServerLoad = Math.max(heavyServerLoad, earliestAvailability[2]);

        //put the modified array object into finishTimeAndServerMinHeap
        finishTimeAndServerMinHeap.add(earliestAvailability);
      }
    }


    List<Integer> resultServer = new ArrayList<>();

    while (!finishTimeAndServerMinHeap.isEmpty()) {
      int[] arr = finishTimeAndServerMinHeap.poll();
      if(heavyServerLoad == arr[2]) resultServer.add(arr[1]);

    }

    Collections.sort(resultServer);
    return resultServer;
  }
}
