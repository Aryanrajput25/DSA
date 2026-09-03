class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean even=true;
        int oddmin=Integer.MAX_VALUE, evenmin=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2!=0){
                even=false;
                oddmin=Math.min(oddmin,nums1[i]);
            }
            else evenmin=Math.min(evenmin,nums1[i]);
        }
        if(!even){
            for(int i=0;i<nums1.length;i++){
                if(nums1[i]%2==0){
                    if(nums1[i]-oddmin>=1) continue;
                    else return false;
                }
            }
        }
        return true;
    }
}