class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            max=Math.max(max,nums[i]);
        }
        int ans=-1;
        for(int i=k;i<=max+k;i+=k){
            if(!set.contains(i)) {
                ans=i;
                break;
            }
        }
        return ans;
    }
}