class Solution {
    public int maxScore(int[] nums, int k) {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        for(int i=0;i<=k-1;i++){
            lsum+=nums[i];
        }
        maxsum=lsum;
        int rightidx=nums.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=nums[i];
            rsum+=nums[rightidx];
            rightidx--;
            maxsum=Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}