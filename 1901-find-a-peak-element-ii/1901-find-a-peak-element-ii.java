class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int maxrowidx=findmaxindex(mat,n,m,mid);
            int left=mid-1>=0?mat[maxrowidx][mid-1]:-1;
            int right=mid+1<m?mat[maxrowidx][mid+1]:-1;
            if(mat[maxrowidx][mid]>left && mat[maxrowidx][mid]>right) return new int[]{maxrowidx,mid};
            else if(mat[maxrowidx][mid]>left) low=mid+1;
            else high=mid-1;
        }
        return new int[]{-1,-1};
    }
    public int findmaxindex(int[][] mat,int n,int m,int col){
        int index=-1, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(mat[i][col]>max){
                max=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}