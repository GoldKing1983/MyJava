package com.interview.leetcode.google.medium;

/*

 */
public class MissingElementInSortedArrayPrint {
    /*
    Base: nums[high] - nums[low] == high-low then all elements are sorted.
    Ex: [4,5,6] ===> 6-4==2-0
    
    If above case matches, then kth value can be answer, if nothing found after it.
    
    */
   
 
  public int missingElement(int[] nums, int k) {
	    int low = 0;
	    int high = nums.length - 1;
	    while (low <= high) {
	        System.out.println("========================================================"); 
	      int mid = low + (high - low) / 2;
	      boolean isLeftSideNoneMissing = nums[mid] - nums[0] == mid;
	      System.out.println("Initially ========= low:" + low + ", mid: " + mid + ", high:" + high +"=========");

	      if (isLeftSideNoneMissing) { // Go Right
		      System.out.println("Between " + nums[0] + " and " + nums[mid] + ", missing size is: " + 0);  
		      System.out.println("Missing size is 0. So going left side. Updating high to " + high);
	        low = mid + 1;
	      } else {
	        int missingSize = nums[mid] - nums[0] - mid;
		      System.out.println("Between " + nums[0] + " and " + nums[mid] + ", missing size is: " + missingSize);  
	        if (missingSize == k) { // Go Left
	        	System.out.println("Missing size  ==k. So going left side. Updating high to " + high);
	          high = mid - 1;
	        } else if (missingSize > k) { // Go Left
	        	System.out.println("Missing size  >k. So going left side. Updating high to " + high);
	          high = mid - 1;
	        } else { // (missingSize<k) // Go Right
	        	System.out.println("Missing size  <k. So going right side. Updating low to " + low);
	          low = mid + 1;
	        }
	      }
	      System.out.println("Updated low and high are ========= low:" + low + ", high:" + high + "=========");
	    }
	      System.out.println("========================================================"); 
	      System.out.println("low went below high. Calculating kth("+k +")number: nums[0]+k+high=" + (nums[0] + k +  high)); 

	    return high + nums[0] + k;
	  }

}
