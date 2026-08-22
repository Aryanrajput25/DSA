class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length) return -1;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        int low=max,high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(nums,k,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    Boolean func(int[] nums, int k, int maxsum){
        int noofk=1, sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+sum<=maxsum){
                sum+=nums[i];
            }
            else{
                noofk++;
                sum=nums[i];
            }
            if(noofk>k) return false;
        }
        return noofk<=k;
    }
}