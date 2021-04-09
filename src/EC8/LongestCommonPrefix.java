package EC8;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i< strs.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strs[i].length()) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] tmp = {"a", "aabbbbb", "aaaccc"};
        System.out.println(solution(tmp));
    }
}
