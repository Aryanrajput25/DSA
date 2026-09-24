class Solution {
    public int minOperations(int[] nums, int x) {
        if(nums[0]>x && nums[nums.length-1]>x) return -1;
        int totalsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }
        int target=totalsum-x;
        int l=0,r=0,sum=0,maxlen=-1;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>target && l<=r){
                sum-=nums[l++];
            }
            if(sum==target) maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        if(maxlen==-1) return -1;
        return nums.length-maxlen;
    }
}