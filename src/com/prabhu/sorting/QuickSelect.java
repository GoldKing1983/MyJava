package com.prabhu.sorting;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * See picture QuickSelect.jpg in "US Problems"
 *
 * By default quick select finds kth Smallest element.
 * Less than symbol is changed in partition to change the function to kth Largest element
 * ================================Implementation Notes======================================
 * 1) It is a binary search with partition logic.
 * 2) Partition Logic returns an "index" which says, the element at this index is sorted. i.e. element at this
 * index is sorted, but elements b4 and after this element is not guaranteed to be sorted, which we
 * are not interested.
 */
public class QuickSelect {
  /*
   * Partition meant arranging one set of data. Partition in quick select picks a pivot (either
   * randomly or first/last element). This logic picks last element. Then it rearranges the list in
   * a way that all elements greater than pivot are on left side of pivot and others on right. It
   * then returns index of the element upto which is sorted.
   */

  // Taking last element as pivot
  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int lowCopy = low;
    while (low < high) {
      // In QuickSort it is if (arr[low] < pivot). Because it is ascending. Here it is descending
      if (arr[low] > pivot) {
        swap(arr, lowCopy, low);
        lowCopy++;
      }
      low++;
    }
    swap(arr, lowCopy, high);
    return lowCopy;
  }

  public int findKthLargest(int[] nums, int k) {
    if (nums.length == 1) return nums[0];
    int low = 0, high = nums.length - 1;
    while (true) {
      int mid = partition(nums, low, high);
      if (mid + 1 == k) return nums[k - 1];
      else if (mid >= k) high = mid - 1;
      else low = mid + 1;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
