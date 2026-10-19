class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller=0, equal=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target) smaller++;
            if(nums[i]==target) equal++;
        }
        for(int i=smaller;i<smaller+equal;i++){
            ans.add(i);
        }
        return ans;
    }
}