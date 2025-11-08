class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxsum=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int j=0;j<accounts[0].length;j++){
                sum=sum+accounts[i][j];
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        return maxsum;
    }
}