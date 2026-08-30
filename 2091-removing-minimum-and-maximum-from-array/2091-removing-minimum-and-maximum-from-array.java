class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, maxidx=-1, minidx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxidx=i;
            }
            if(nums[i]<min){
                min=nums[i];
                minidx=i;
            }
        }
        int op1=Math.max(maxidx,minidx)+1;
        int op2=n-Math.min(maxidx,minidx);
        int op3=Math.min(maxidx,minidx)+1+n-Math.max(maxidx,minidx);
        return Math.min(op1,Math.min(op2,op3));
    }
}