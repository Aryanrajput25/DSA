class Solution {
    public int[] replaceElements(int[] nums) {
        int n=nums.length;
        int maxright=-1;
        for(int i=n-1;i>=0;i--){
            int curr=nums[i];
            nums[i]=maxright;
            maxright=Math.max(curr,maxright);
        }
        return nums;
    }
}