class Solution {
    public int majorityElement(int[] nums) {
        int no=0;
        int count=0;
        for (int i=0;i<nums.length;i++){
            if(count==0){
                count++;
                no=nums[i];
            }
            else if(no==nums[i]){
                count++;

            }
            else{
                count--;
            }
        }
        return no;
    }
}