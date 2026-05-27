class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l=0;
        int r=0;
        int n=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while(r<n && l<g.length){
            if(g[l]<=s[r]) l++;
            r++;
        }
        return l;
    }
}