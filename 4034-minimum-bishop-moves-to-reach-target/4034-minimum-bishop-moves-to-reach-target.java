class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        if(source[0]==target[0]&&source[1]==target[1]) return 0;
        if((source[0]+source[1])%2==0){
            if((target[0]+target[1])%2!=0) return -1;
            if((source[0]+source[1])==(target[0]+target[1])||source[0] - source[1] == target[0] - target[1]) return 1;
            else return 2;
        }
        if((source[0]+source[1])%2!=0){
            if((target[0]+target[1])%2==0) return -1;
            if((source[0]+source[1])==(target[0]+target[1])||source[0] - source[1] == target[0] - target[1]) return 1;
            else return 2;
        }
        return -1;
    }
}