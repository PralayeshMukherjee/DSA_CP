
// 904. Fruit Into Baskets
// Link: https://leetcode.com/problems/fruit-into-baskets/description/
import java.util.*;

public class q2 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = fruits.length, count = 0;
        while (j < n) {
            int temp = fruits[j];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            count = Math.max(count, j - i + 1);
            j++;
        }
        return count;
    }
}
