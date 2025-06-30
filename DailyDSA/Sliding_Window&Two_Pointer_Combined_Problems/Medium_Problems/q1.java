
// Longest Substring Without Repeating Characters
// link:- https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.HashMap;
import java.util.Map;

public class q1 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (!map.containsKey(ch) || map.get(ch) < i) {
                count = Math.max(count, j - i + 1);
                map.put(ch, j);
            } else {
                i = map.get(ch) + 1;
                map.remove(ch);
                map.put(ch, j);
            }
            j++;
        }
        return count;
    }
}
// TC:- O(2N)(some times i and j can traverse whole array)
// SC:- O(N)