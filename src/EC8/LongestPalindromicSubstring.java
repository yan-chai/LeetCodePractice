package EC8;

import java.util.Collections;
import java.util.HashMap;

public class LongestPalindromicSubstring {

    public static String solution(String s) {
        int len = s.length();
        HashMap<Integer, String> re = new HashMap<>();
        re.put(0, "");
        for (int i = 0; i < len; ++i) {
            for (int j = len - 1; j >= i +  Collections.max(re.keySet()); --j) {
                if (s.charAt(i) == s.charAt(j)) {
                    String str = s.substring(i, j + 1);
                    if (isPalindrome(str)) {
                        if (str.length() == s.length())
                            return s;
                        if (str.length() > Collections.max(re.keySet())) {
                            re.put(str.length(), str);
                            break;
                        }
                    }
                }
            }
        }
        return re.get(Collections.max(re.keySet()));
    }

    public static boolean isPalindrome(String text) {
        int length = text.length();
        for (int i = 0; i <= length / 2; ++i) {
            if (text.charAt(i) != text.charAt(length - i - 1))
                return false;
        }
        return true;
    }

}
