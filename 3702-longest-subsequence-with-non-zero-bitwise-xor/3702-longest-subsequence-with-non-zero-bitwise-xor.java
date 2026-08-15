class Solution {
    public int longestSubsequence(int[] nums) {
        Boolean hasfullzero=true;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(nums[i]!=0){
                hasfullzero=false;
            }
        }
        if(xor!=0) return nums.length;
        if(hasfullzero) return 0;
        else return nums.length-1;
    }
}