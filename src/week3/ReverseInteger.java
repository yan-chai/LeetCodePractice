import java.util.Stack;

/*
https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    /*
     * Overflow!!!!
     * Time: O(logn); Space: O(n);
     * */
    public static int BadSolution(int x) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        while (x / 10 != 0) {
            stack.add(x%10);
            x = x / 10;
        }
        result += x;
        while (!stack.isEmpty()) {
            result = (int) (result + stack.pop()*(Math.pow(10, index)));
            index++;
        }
        return result;
    }

    /*
     * The logic of this Algorithm is similar to the mine, but it can deal with overflow
     * Time: O(logn); Space: O(n);
     * */

    public static int solution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(BadSolution(153423));
    }
}
