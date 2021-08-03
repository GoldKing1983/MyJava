package com.sample.datastructure.algorithm.interview;

/*

1) The basic idea of dynamic programming is to store the results of previous calculation and
2) Reuse it in future calculations, instead of recalculating them.

============================When to apply DP============================
1) Apply dp only when question is about count/trueOrFalse/max/min/optimizedPath.... 
2) If anywhere combination/permutation/subList/sequence is asked never try DP.... 
Sometimes it is not possible, sometimes it complicates... I can point 100+ problems...
============Analysis Problem1============  
1) WordBreak ask you to return true or false. So DP is possible along with other combination of solution(Recursion/MemoDP/DP-BottomUpDP/BFS). 
2) In WordBreakII same requirement as WordBreak, but u have to get all combinationOfSolution.. So DP solution is complicated. So best solution is BFS/DFS only...
https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns
============Analysis Problem2============
1) CombinationSumIV ask you to return true or false. So DP is best.
2) CombinationSumOrCoinChange is same requirement as CombinationSumIV, but ask you to return all combinations. Best solution is DFS-backtracking...

=======For the coin-change problem======
1) Define SubProblems (1 coin to make target)
2) Relate SubProblem solutions (2 coin to make target)
3) Recurse & memoize or build DP table bottom-up
4) Solve original problem
=======For climbing stairs problem======
1) Solution for 5 can be arrived from Solution3 and Solution4...
2) Solution for 4 can be arrived from Solution2 and Solution3...
3) Solution for 3 can be arrived from Solution1 and Solution2... 
===============================Problems===============================
1) UniquePathsDP
2) MinimumPathSumDP
3) MaximalSquare
4) CountingBits
5) CombinationSumIV
===============================Fibonacci style DP======================
1) ClimbingStairs
2) MinCostClimbingStairs
3) BestTimeToBuyAndSellStockWithCooldown
4) HouseRobber
5) PaintFence
6) PaintHouse
 */
public class DPInterviewPoint {
}
