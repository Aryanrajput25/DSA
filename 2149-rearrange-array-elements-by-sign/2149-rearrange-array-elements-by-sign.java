class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posidx=0;
        int negidx=1;
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[negidx]=nums[i];
                negidx+=2;
            }
            else{
                ans[posidx]=nums[i];
                posidx+=2;
            }
        }
        return ans;
    }
}