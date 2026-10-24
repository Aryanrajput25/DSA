class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int l=0, r=0;
        long count=0;
        while(r<nums.length){
            if(nums[r]>=minK && nums[r]<=maxK) count+=r-l+1;
            if(nums[r]<minK || nums[r]>maxK) l=r+1;
            r++;
        }
        return count;
    }
}