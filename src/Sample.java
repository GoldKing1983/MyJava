import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
===========================================================Requirement===========================================================
===========================================================BruteForce============================================================
============================================================Example1=============================================================
========================================================Solution Approach========================================================
=======================================================Data Flow Analysis========================================================
=================================================================================================================================
 */
public class Sample {

  /*
   * 10,20,5 = 
   * 10,20,2
   * 
   */
  public static void main(String args[]) throws Exception {
    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(2);
    intList.add(3);


    String numberString = intList.stream().map(String::valueOf)
        .collect(Collectors.joining(","));
    System.out.println(numberString); //<- this prints [1, 2, 3]
    
    String[] split = numberString.split(",");
    System.out.println(Arrays.toString(split));

  }

}
