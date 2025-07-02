// 930. Binary Subarrays With Sum
// Link:- https://leetcode.com/problems/binary-subarrays-with-sum/description/

public class q4 {
    public int f(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int i = 0, j = 0, sum = 0, count = 0, n = nums.length;
        while (j < n) {
            sum += nums[j];
            while (sum > goal) {
                sum -= nums[i];
                i++;
            }
            count = count + (j - i + 1);
            j++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums, goal) - f(nums, goal - 1);
    }
}
// TC:- O(N+N)
// SC:- O(1)