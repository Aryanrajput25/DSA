class Solution {
    public int differenceOfSum(int[] nums) {
        int dsum=0, esum=0;
        for(int i=0;i<nums.length;i++){
            esum+=nums[i];
            int num=nums[i];
            while(num>0){
                dsum+=num%10;
                num/=10;
            }
        }
        return esum-dsum;
    }
}