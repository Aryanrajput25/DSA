class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for (int i=0;i<4;i++){
            if (check(mat,target)) return true;
            mat=rotate(mat);
        }
        return false;
    }
    public int[][] rotate(int[][] m){
        int n=m.length;
        int[][] rot = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rot[j][n-1-i]=m[i][j];
            }
        }
        return rot;
    }
    public boolean check(int[][] m , int[][] t){
        int n=m.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]!=t[i][j]) return false;
            }
        }
        return true;
    }
    
}