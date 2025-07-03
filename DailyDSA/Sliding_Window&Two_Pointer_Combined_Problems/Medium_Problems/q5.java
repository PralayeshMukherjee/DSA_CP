// 1248. Count Number of Nice Subarrays
// Link:- https://leetcode.com/problems/count-number-of-nice-subarrays/description/

public class q5 {
    public int f(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length, oddcount = 0, nice = 0;
        while (j < n) {
            if (nums[j] % 2 != 0) {
                oddcount++;
            }
            while (oddcount > k) {
                if (nums[i] % 2 != 0) {
                    oddcount--;
                }
                i++;
            }
            nice = nice + (j - i + 1);
            j++;
        }
        return nice;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }
}
// TC:- O(N+N)
// SC:- O(1)