class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans=false;
        int m=matrix[0].length;
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    ans=true;
                }
            }
        }
        return ans;
    }
}