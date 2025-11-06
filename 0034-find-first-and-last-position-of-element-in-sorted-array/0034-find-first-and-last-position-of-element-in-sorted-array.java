class Solution {
    /**
     * Find the starting and ending position of a given target value in a sorted array.
     * @param nums - sorted array of integers
     * @param target - target value to search for
     * @return array containing [start_index, end_index] of target, or [-1, -1] if not found
     */
    public int[] searchRange(int[] nums, int target) {
        // Find the leftmost position where target could be inserted
        int leftBoundary = findLeftBoundary(nums, target);
      
        // Find the leftmost position where (target + 1) could be inserted
        // This gives us the position right after the last occurrence of target
        int rightBoundaryPlusOne = findLeftBoundary(nums, target + 1);
      
        // If both boundaries are the same, target doesn't exist in the array
        if (leftBoundary == rightBoundaryPlusOne) {
            return new int[] {-1, -1};
        }
      
        // Return the range: [leftBoundary, rightBoundaryPlusOne - 1]
        return new int[] {leftBoundary, rightBoundaryPlusOne - 1};
    }
  
    /**
     * Binary search to find the leftmost position where targetValue could be inserted.
     * This finds the first occurrence of values >= targetValue.
     * @param nums - sorted array of integers
     * @param targetValue - value to search for
     * @return index of the leftmost position where targetValue should be inserted
     */
    private int findLeftBoundary(int[] nums, int targetValue) {
        int left = 0;
        int right = nums.length;
      
        // Binary search for the leftmost position
        while (left < right) {
            // Calculate middle index (using unsigned right shift to avoid overflow)
            int mid = (left + right) >>> 1;
          
            // If mid element is greater than or equal to targetValue,
            // the answer lies in the left half (including mid)
            if (nums[mid] >= targetValue) {
                right = mid;
            } else {
                // Otherwise, the answer lies in the right half (excluding mid)
                left = mid + 1;
            }
        }
      
        return left;
    }
}
