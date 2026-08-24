class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {

        List<List<Integer>> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        // Store all numbers present in nums
        for (int num : nums) {
            set.add(num);
        }

        int start = -1;

        for (int i = lower; i <= upper; i++) {

            if (!set.contains(i)) {
                // Start of a missing range
                if (start == -1) {
                    start = i;
                }
            } 
            else {
                // End of a missing range
                if (start != -1) {
                    ans.add(Arrays.asList(start, i - 1));
                    start = -1;
                }
            }
        }

        // If missing range continues till upper
        if (start != -1) {
            ans.add(Arrays.asList(start, upper));
        }

        return ans;
    }
}