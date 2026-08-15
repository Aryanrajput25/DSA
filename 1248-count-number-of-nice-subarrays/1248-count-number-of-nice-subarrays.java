class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]%2;
        }
        return find(nums,k)-find(nums,k-1);
    }
    public int find(int[] nums, int k){
        int l=0,r=0,sum=0,count=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }

}