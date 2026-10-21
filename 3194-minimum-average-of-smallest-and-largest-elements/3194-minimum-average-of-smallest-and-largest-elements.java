class Solution {
    public double minimumAverage(int[] nums) {
        float[] avg=new float[nums.length/2];
        Arrays.sort(nums);
        float min=Float.MAX_VALUE;
        int left=0, right=nums.length-1;
        for(int i=0;i<nums.length/2;i++){
            float num=(nums[left]+nums[right])/2.0f;
            left++;
            right--;
            avg[i]=num;
            min=Math.min(min,num);
        }
        return min;
    }
}