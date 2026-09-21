class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];
            int r = num % k;

            next[r]++;

            for (int rem = 0; rem < k; rem++) {
                next[(rem * r) % k] += dp[rem];
            }

            for (int rem = 0; rem < k; rem++) {
                result[rem] += next[rem];
            }

            dp = next;
        }

        return result;
    }
}