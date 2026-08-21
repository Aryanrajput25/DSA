class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int high=max, low=1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(find(nums,threshold,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    Boolean find(int[] nums, int threshold, int divisor){
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=Math.ceil((double)nums[i]/divisor);
            if(count>threshold) return false;
        }
        return count<=threshold;
    }
}