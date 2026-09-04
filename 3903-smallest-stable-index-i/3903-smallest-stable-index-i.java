class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int score=0, n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min=Math.min(min,nums[j]);
            }
            score=max-min;
            if(score<=k) return i;
        }
        return -1;
    }
}