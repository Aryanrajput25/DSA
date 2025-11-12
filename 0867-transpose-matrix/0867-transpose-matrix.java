class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows=matrix.length;
        int coloumn=matrix[0].length;

        int[][] ans=new int[coloumn][rows];
        for(int i=0;i<coloumn;i++){
            for(int j=0;j<rows;j++){
                ans[i][j]=matrix[j][i];
            }
        }
        return ans;
    }
}