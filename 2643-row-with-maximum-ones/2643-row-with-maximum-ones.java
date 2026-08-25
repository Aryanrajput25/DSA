class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxcount=-1, index=-1;
        int m=mat[0].length, n=mat.length;
        for(int i=0;i<n;i++){
            int countones=0;
            for(int j=0;j<m;j++){
                countones+=mat[i][j];
            }
            if(countones>maxcount){
                maxcount=countones;
                index=i;
            }
        }
        return new int[]{index,maxcount};
    }
    
}