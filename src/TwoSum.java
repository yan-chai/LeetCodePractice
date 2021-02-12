import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    /*
    * This is the code write by myself (looks like brute force solution)
    * Time: O(n^2); Space: O(1);
    * */
    public static int[] solution(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /*
     * This is the code write after I see the solution (HashTable solution)
     * Time: O(n); Space: O(n);
     * */
    public static int[] bestSolution(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numbers.containsKey(complement)) {
                return new int[] { numbers.get(complement), i };
            }
            numbers.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {3,2,6,1,0,-7};
        System.out.println(Arrays.toString(solution(numbers,-1)));
    }

}
