class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findmax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int totalhr=calculatetotalhr(piles,mid);
            if(totalhr<=h) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int findmax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    public int calculatetotalhr(int[] nums,int hourly){
        int totalhr=0;
        for(int i=0;i<nums.length;i++){
            totalhr+=Math.ceil((double)nums[i]/hourly);
        }
        return totalhr;
    }
}