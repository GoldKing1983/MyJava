package com.sample.tricky;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array
 *
1) Find Largest Number using priority queue
2) Find Largest Number using Quick select
algorithm Image is Present on US Problems folder "Quick Select.jpg"
 *
1) Partition meant arranging "one" data in set of data.
2) Partition in quick select picks a pivot (either randomly or first/last element).
3) This logic picks last element.
4) Then it rearranges the list in a way that all elements greater than pivot are on left side of pivot and others on right.
5) It then returns index of the element upto which is sorted.
 */
public class KthLargestElementInAnArrayQuickSelect {
  public int findKthLargest(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;
    return findKthLargest(nums, left, right, nums.length - k);
  }

  private int findKthLargest(int[] nums, int left, int right, int k) {
    int pivot = nums[right];
    int start = left, end = right;
    for (int i = start; i < end; i++) {
      if (nums[i] <= pivot) swap(nums, start++, i); // Put numbers < pivot to pivot's left
    }
    swap(nums, start, end); // Finally, swap A[end] with A[left]

    if (start == k) return nums[start]; // Found kth smallest number
    else if (start < k) return findKthLargest(nums, start + 1, end, k); // Check right part
    else return findKthLargest(nums, left, start - 1, k); // Check left part
  }

  void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
