class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int deptha=0, depthb=0, depth=0;
        int[] ans=new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            int val=0;
            if(seq.charAt(i)=='('){
                depth++;
                if(depth%2==1){
                    val=0;
                    ans[i]=val;
                }
                else{
                    val=1;
                    ans[i]=val;
                }
            }
            else{
                if(depth%2==1) {
                    val=0;
                    ans[i]=val;
                }
                else {
                    val=1;
                    ans[i]=val;
                }
                depth--;
            }
        }
        return ans;
    }
}