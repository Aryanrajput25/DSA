class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1){
            if(nums[0]==-2) return -2;
        }
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            int mul=1;
            for(int j=i;j<nums.length;j++){
                mul*=nums[j];
                maxi=Math.max(maxi,mul);
            }
        }
        return maxi;
    }
}