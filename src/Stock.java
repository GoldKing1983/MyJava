public class Stock {
  int minOfLeftHalf = Integer.MAX_VALUE;
  int minIndex = -1;

  int maxOfRightHalf = Integer.MIN_VALUE;
  int maxIndex = -1;

  public int getMaxProfit(int[] nums, int low, int high) {

    if (low == high) return 0;

    int mid = low + (high - low) / 2;

    if (nums[low] < minOfLeftHalf) {
      minOfLeftHalf = nums[low];
      minIndex = low;
    }
    if (nums[mid] < minOfLeftHalf) {
      minOfLeftHalf = nums[mid];
      minIndex = mid;
    }

    int left = getMaxProfit(nums, low, mid);

    if (nums[mid + 1] > maxOfRightHalf) {
      maxOfRightHalf = nums[mid + 1];
      maxIndex = mid + 1;
    }
    if (nums[high] > maxOfRightHalf) {
      maxOfRightHalf = nums[high];
      maxIndex = high;
    }

    int right = getMaxProfit(nums, mid + 1, high);

    return Math.max(Math.max(left, right), maxOfRightHalf - minOfLeftHalf);
  }

  public static void main(String[] args) {
    Stock stock = new Stock();
    // int[] input = new int[] {5, 10, 4, 6, 12};
    // int[] input = new int[] {5, 10, 12, 6, 4};
    int[] input = new int[] {1, 2, 3};
    System.out.println(stock.getMaxProfit(input, 0, input.length - 1));
    System.out.println("BuyIndex is " + stock.minIndex + ". Sell Index is " + stock.maxIndex);
  }
}
