// 424. Longest Repeating Character Replacement
// Link:- https://leetcode.com/problems/longest-repeating-character-replacement/description/

import java.util.HashMap;
import java.util.Map;

public class q3 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), count = 0, maxfreq = 0;
        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(ch));
            while ((j - i + 1) - maxfreq > k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.get(s.charAt(i)) <= 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            count = Math.max(count, j - i + 1);
            j++;
        }
        return count;
    }
}
