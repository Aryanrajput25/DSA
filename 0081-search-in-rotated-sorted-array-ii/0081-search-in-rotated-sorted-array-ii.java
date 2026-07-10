class Solution {
    public Boolean search(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(nums[mid]==target) return true;
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && nums[mid]>=target){
                    end=mid-1;
                }
                else start=mid+1;
            }
            if(nums[mid]<=nums[end]){
                if(nums[end]>=target && nums[mid]<=target){
                    start=mid+1;
                }
                else end=mid-1;
            }
        }
        return false;
    }
}