class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int first=first(nums,target,n);
        if(first==-1) return new int[]{-1,-1};
        int last=last(nums,target,n);
        return new int[]{first,last};
    }
    public int first(int[] nums,int target,int n){
        int low=0;
        int high=n-1;
        int first=-1;
        while(low<=high){
            int mid=low + (high - low) / 2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return first;
    }
    public int last(int[] nums,int target,int n){
        int low=0;
        int high=n-1;
        int last=-1;
        while(low<=high){
            int mid=low + (high - low) / 2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return last;
    }
}