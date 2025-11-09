class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans=new int[image.length][image.length];
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image.length;j++){
                ans[i][j] = image[i][image.length - 1 - j];
            }
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image.length;j++){
                if(ans[i][j]==1){
                    ans[i][j]=0;
                }
                else{
                    ans[i][j]=1;
                }
            }
        }
        return ans;
    }
}