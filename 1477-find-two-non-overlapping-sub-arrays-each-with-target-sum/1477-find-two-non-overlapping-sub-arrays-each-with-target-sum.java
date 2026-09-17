class Solution {
    public int minSumOfLengths(int[] nums, int target) {
        int n = nums.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (right > 0) {
                best[right] = best[right - 1];
            }
            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, best[left - 1] + len);
                }
                best[right] = Math.min(best[right], len);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}