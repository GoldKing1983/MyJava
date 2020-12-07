package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/gas-station/

1) There are N gas stations in a circular route
2) I can start at any gas station and move only clock-wise
3) Start at any gas station and make sure to reach the same point again.
If there is no way, I can reach to same point again return -1.


See image "GasStation.png" for understanding
====================================================Sample1====================================================
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Above Input can be translated to
gas  = [1==>2==>3==>4==>5==>1]
cost = [  3   4   5   1   2  ]

If I start from 1. Then I will get "1" unit gas. To travel to next (i.e) 2 I need "3" unit gas.

Output: 3
Explanation:
Start at station 3 (index 3. i.e 4) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
====================================================Sample2====================================================
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation: You can't travel around the circuit once no matter where you start.
==============================================Solution Approach==================================================
1) Very first point to understand is if "sumGas < sumCost" then I can never reach the "gas station where I started".
2) If "sumGas >= sumCost" then there is a path.
3) To identify the right "start gas station", start from "gas station1"
4) move to "gas station2". Calculate "currentTankRemaining".
5) if totalTankRemaining >= 0. Add currentTankRemaining.
6) Else reset totalTankRemaining and update start to "current gas station"

 */
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sumGas = 0;
    int sumCost = 0;
    int startGasStation = 0;
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      sumGas += gas[i];
      sumCost += cost[i];
    }
    if (sumGas < sumCost) return -1;

    int totalTankRemaining = 0;
    for (int gasStationId = 0; gasStationId < gas.length; gasStationId++) {
      int currentTankRemaining = gas[gasStationId] - cost[gasStationId];

      // if sum remaining of (i-1) >= 0, continue
      if (totalTankRemaining >= 0) {
        totalTankRemaining += currentTankRemaining;
      } else { // Reset
        totalTankRemaining = currentTankRemaining;
        startGasStation = gasStationId;
      }
    }

    return startGasStation;
  }
}
