class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] smallest= new int[n];
        smallest[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            smallest[i]=Math.min(smallest[i+1],nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            if((max-smallest[i])<=k) return i;
        }
        return -1;
    }
}