class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int mid=0;
        int last=nums.length-1;
        while(mid<=last){
            if(nums[mid]==0){
                swap(nums,mid,start);
                mid++;
                start++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,last);
                last--;
            }
            else{
                mid++;
            }
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp;
        temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        
    }
}