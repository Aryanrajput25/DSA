class Solution {
    public int findGCD(int[] nums) {
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        while(max!=0){
            int temp=max;
            max=min%max;
            min=temp;
        }
        return min;
    }
}