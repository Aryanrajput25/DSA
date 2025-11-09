class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int[] ans= new int[gain.length+1];
        ans[0]=0;
        //ans[1]=gain[0];
        for(int i=1;i<=gain.length;i++){
            ans[i]=ans[i-1]+gain[i-1];
            if(ans[i]>max){
                max=ans[i];
            }
        }
        return max;
    }
}