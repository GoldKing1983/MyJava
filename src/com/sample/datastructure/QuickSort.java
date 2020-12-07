package com.sample.datastructure;

/*

Ex: [1, 3, 2, 8, 7, 6, 5, 4]

In the first round of quick sort, we pick the last element 4 as the pivot,
which partitions the original list into two sublists: [1, 3, 2] and [8, 7, 6, 5] respectively.

Next, we recursively sort the above two sublists.
For instance, for the sublist [1, 3, 2], again we pick the last element (i.e. 2) as the pivot value.
After this partitioning, we obtain two sublists with a single element, which is the base case of the recursion.

Once we sorted the sublists [1, 3, 2] and [8, 7, 6, 5] respectively, we simply concatenate the
sorted results together with the pivot value (4) to form the final result, i.e. [1, 2, 3] + [4] + [5, 6, 7, 8].

See image "QuickSort.png"
 */
public class QuickSort {

  public void quickSort(int[] arr) {
    int n = arr.length;
    qSort(arr, 0, n - 1);
  }

  private void qSort(int[] lst, int low, int high) {
    if (low < high) {
      int p = partition(lst, low, high);
      qSort(lst, low, p - 1);
      qSort(lst, p + 1, high);
    }
  }

  // Picks the last element high as pivot and returns the index of pivot value in sorted array
  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int lowCopy = low;
    while (low < high) {
      if (arr[low] < pivot) {
        swap(arr, lowCopy, low);
        lowCopy++;
      }
      low++;
    }
    swap(arr, lowCopy, high);
    return lowCopy;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
