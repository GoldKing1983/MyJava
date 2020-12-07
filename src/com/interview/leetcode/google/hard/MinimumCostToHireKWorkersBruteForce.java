package com.interview.leetcode.google.hard;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
Requirements: Little Bit Confusing.
1) A worker can do "quality work" of x and get "wages" of "y".
2) We need to find "K" worker to a job with minimum wages.
3) Condition: We need to pick "one person as Captain". Based to how much he got paid "per unit wage",
we need to share the same wage to everyone.
Ex: Person1. quality= 10, wage= 70.  "per unit wage" = 7. If he is selected as captain.
	Person2. quality= 5, wage = 30. We need to give (7*5)=35 for Person2.

4) Condition: When we give the same "per unit wage" to other worker, if their minimum wage is not met.
Then that worker cannot selected.

Ex: In below Example. When captain is index1. "per unit wage" is 50/20=2.5
If I give the same to worker at index0. Then it is 10*2.5=25. His minimum expectation is 70. So he cannot be selected.
If I give the same to worker at index2. Then it is 5*2.5=12.5. His minimum expectation is 30. So he cannot be selected also.

Ex: There are 3 workers.
Input: quality = [10,20,5],
          wage = [70,50,30], K = 2
============================================================================================================================
Input: quality = [10,20,5],
          wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
			===================================================
The captain is at index: 0 his wage is:70 and the perUnitWage is:70.0/10=7.0
			[Cap , 7*20 , 7*5 ]
Before Sort:[70.0, 140.0, 35.0]
After Sort :[35.0, 70.0, 140.0] ==> sum of top2 will be considered for result=======> 105
			===================================================
The captain is at index: 1 his wage is:50 and the perUnitWage is:50.0/20=2.5
			[MNM, Cap ,MNM] ==>MNM= Minimum Wage Not Met
Before Sort:[∞  , 50.0, ∞ ]
Not considered for result. Because minimum workers not met i.e workers < K
			===================================================
The captain is at index: 2 his wage is:30 and the perUnitWage is:30.0/5=6.0
			[MNM , 6*20 ,  Cap] ==>MNM= Minimum Wage Not Met
Before Sort:[∞   , 120.0, 30.0]
After Sort :[30.0, 120.0, ∞   ] ==> sum of top2 will be considered for result. ========> 150

Min(105,150) ===============> 105 is the answer
============================================================================================================================
 */
public class MinimumCostToHireKWorkersBruteForce {

  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    int N = quality.length;
    double minimumWageToPay = 1e9;

    for (int captain = 0; captain < N; ++captain) {
      // Must pay at least wage[captain] / quality[captain] per equal
      double perUnitWage = (double) wage[captain] / quality[captain];
      double prices[] = new double[N];
      int totalInvalid = 0;
      for (int worker = 0; worker < N; ++worker) {
        if (worker == captain) { // For Captain, pay his full amount.
          prices[worker] = wage[worker];
          continue;
        }
        double priceForWorker = perUnitWage * quality[worker];
        if (priceForWorker < wage[worker]) { // Verify minimum wage not met
          totalInvalid++;
          prices[worker] = Double.MAX_VALUE;
          continue;
        }
        prices[worker] = priceForWorker;
      }
      if (N - totalInvalid < K) continue;
      Arrays.sort(prices);
      // System.out.println(Arrays.toString(prices));
      double sumOfWages = 0;
      for (int i = 0; i < K; ++i) sumOfWages += prices[i];
      minimumWageToPay = Math.min(minimumWageToPay, sumOfWages);
    }

    return minimumWageToPay;
  }
}
