class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length=0;
        int max=0;
        for(int i:nums){
            if(i==1){
                length++;
                max=Math.max(length,max);
            }
            else{
                max=Math.max(length,max);
                length=0;
            }
        }
        return max;
    }
}