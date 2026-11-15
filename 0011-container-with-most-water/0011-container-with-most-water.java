class Solution {
    public int maxArea(int[] height) {
        int maxarea=0, l=0, r=height.length-1;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            maxarea=Math.max(maxarea,area);
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return maxarea;
    }
}