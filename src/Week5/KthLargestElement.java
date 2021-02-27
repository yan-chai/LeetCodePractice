//https://leetcode.com/problems/kth-largest-element-in-an-array/
package Week5;

import java.util.Arrays;

public class KthLargestElement {

    //use quick to sort and select Kth element
    public static int partition(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int pivotElem = arr[mid];
        int tmp = arr[high];
        arr[high] = pivotElem;
        arr[mid] = tmp;
        int last = high;
        while (low < high) {
            while (low < high && arr[low] < pivotElem) {
                low ++;
            }
            while (low < high && arr[high] >= pivotElem) {
                high --;
            }
            tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
        tmp = arr[high];
        arr[high] = pivotElem;
        arr[last] = tmp;
        return high;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int indexOfPivot;
        if (low <= high) {
            indexOfPivot = partition(arr, low, high);
            quickSort(arr, low, indexOfPivot - 1);
            quickSort(arr, indexOfPivot + 1, high);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
}
