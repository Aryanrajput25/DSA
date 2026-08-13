class Solution {
    public int totalFruit(int[] nums) {
        int l=0,r=0,maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.size()>2){
                while(map.size()>2){
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if(map.get(nums[l])==0) map.remove(nums[l]);
                    l++;
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}