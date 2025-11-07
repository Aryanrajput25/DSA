class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = left(nums, target);
        int end = right(nums, target);
        return new int[]{start, end};
    }

    private int left(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                r = mid - 1; 
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    private int right(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                l = mid + 1; 
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}
