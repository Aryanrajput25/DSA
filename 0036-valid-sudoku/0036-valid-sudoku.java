class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                char val=board[i][j];
                for(int k=0;k<9;k++){
                    if(k!=j && board[i][k]==val) return false;
                    if(k!=i && board[k][j]==val) return false;
                    int row=(3*(i/3)+(k/3));
                    int col=3*(j/3)+(k%3);
                    if(i!=row && j!=col && board[row][col]==val) return false;
                }
            }
        }
        return true;
    }
}