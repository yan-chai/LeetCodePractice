//https://leetcode.com/problems/median-of-two-sorted-arrays/
package week6;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double solution(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i1 = 0, i2 = 0;
        int[] tmp = new int[l1+l2];
        while (i1 < l1 && i2 < l2) {
            if (nums1[i1] < nums2[i2]) {
                tmp[i1+i2] = nums1[i1];
                i1++;
            } else {
                tmp[i1+i2] = nums2[i2];
                i2++;
            }
        }
        while (i1 < l1) {
            tmp[i1+i2] = nums1[i1];
            i1++;
        }
        while (i2 < l2) {
            tmp[i1+i2] = nums2[i2];
            i2++;
        }
        System.out.println(Arrays.toString(tmp));
        if ((l1 + l2) % 2 == 0) {
            return (tmp[(l1+l2)/2] + tmp[(l1+l2)/2 - 1]) / 2.0;
        } else {
            return tmp[(l1+l2) / 2] / 1.0;
        }
    }

    //This is the best solution provided by LeetCode
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {4,5,6};
        System.out.println(solution(a, b));
    }
}

