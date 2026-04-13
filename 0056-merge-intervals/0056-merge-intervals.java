

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int index = 0; // Points to last merged interval

        for (int i = 1; i < intervals.length; i++) {

            // If overlapping
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] =
                        Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // Move index forward and copy interval
                index++;
                intervals[index] = intervals[i];
            }
        }

        // Return only merged part
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }
}