class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth=0;
        int[] ans=new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            int val=0;
            if(seq.charAt(i)=='('){
                depth++;
                ans[i]=depth%2;
            }
            else{
                ans[i]=depth%2;
                depth--;
            }
        }
        return ans;
    }
}