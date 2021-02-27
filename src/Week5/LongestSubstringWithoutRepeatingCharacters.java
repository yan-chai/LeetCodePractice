//https://leetcode.com/problems/longest-substring-without-repeating-characters/
package Week5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int solution(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int tmp = 0;
        int result = 0;
        HashMap<Character, Integer> map;
        for (int i = 0; i < len; i++) {
            tmp = 0;
            map = new HashMap<Character, Integer>();
            for (int j = i; j < len; j++) {
                if (!map.containsKey(s.charAt(j))) {
                    tmp++;
                    System.out.println(tmp);
                    map.put(s.charAt(j), 1);
                } else {
                    if (result < tmp) {
                        result = tmp;
                    }
                    break;
                }
            }
            if (result < tmp) {
                result = tmp;
            }
        }
        return result;
    }

    //best solution
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
