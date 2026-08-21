class Solution {
    public int minDays(int[] nums, int m, int k) {
        long val=(long)m*k;
        if(val>nums.length) return-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int high=max, low=min;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(find(nums,m,k,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    Boolean find(int[] nums,int m, int k, int day){
        int count=0, noofb=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=day){
                count++;
            }
            else{
                noofb+=(count/k);
                count=0;
            }
        }
        noofb+=(count/k);
        return noofb>=m;
    }
}