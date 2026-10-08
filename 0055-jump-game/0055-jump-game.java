class Solution {
    public boolean canJump(int[] nums) {
        int maxidx=0;
        if(nums.length==1) return true;
        for(int i=0;i<nums.length;i++){
            if(i>maxidx) return false;
            maxidx=Math.max(maxidx,i+nums[i]);
            
        }
        return true;
    }
}