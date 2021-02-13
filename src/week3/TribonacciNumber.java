/*
https://leetcode.com/problems/n-th-tribonacci-number/
 */


public class TribonacciNumber {
    public static int solution(int n) {
        if (n == 0) {
            return 0;
        }if (n == 1 && n == 2) {
            return 1;
        }
        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 3; i <= n; i++) {
            numbers[i] = numbers[i-1] + numbers[i-2] + numbers[i-3];
        }
        return numbers[n];
    }
}
