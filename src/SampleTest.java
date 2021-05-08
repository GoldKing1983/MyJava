import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class SampleTest {
  /**
  * Question 1: Get all unused keys in the array
  * @param allKeys, all unique keys we have
  * @param usedKeys, the keys which were used
  * @return restKeys, the rest keys
  */
  public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
    // allKeys = [1,2,3,4,5]
    // usedKeys = [1,3,5]
    // result = [2,4]

    Set<Integer> set = new HashSet<>();
    for (int usedKey : usedKeys) {
      set.add(usedKey);
    }

    List<Integer> result = new ArrayList<>();
    for (int allKey : allKeys) {
      if (!set.contains(allKey)) result.add(allKey);
    }

    int[] resultArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArray[i] = result.get(i);
    }


    return resultArray;

  }

  @Test
  public void testUnUsedKeys() {
    SampleTest t = new SampleTest();
    int[] allKeys = {1, 2, 3, 4, 5};
    int[] usedKeys = {1, 3, 5};
    int[] expectedResult = {2, 4};
    int[] result = t.getUnUsedKeys(allKeys, usedKeys);
    Assert.assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
  }


}
