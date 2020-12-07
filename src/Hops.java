import java.util.Arrays;

public class Hops {
  private int hopEasy(int[] nums, int x) {
    if (x == nums[x]) return 0;

    int temp = nums[x];
    nums[x] = nums[nums[x]];
    int count = hopEasy(nums, x) + 1;
    nums[x] = temp;
    return count;
    
  }

  public static void main(String[] args) {
    Hops s = new Hops();
    int[] input = new int[] {5, 1, 0, 4, 2, 3};
    System.out.println("Find 3 " + s.hopEasy(input, 3));
    System.out.println(Arrays.toString(input));

    System.out.println("Find 5 " + s.hopEasy(input, 5));
    System.out.println(Arrays.toString(input));
  }
}
