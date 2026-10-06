class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length, m=matrix[0].length, maxsum=0;
        int[][] prefix=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0') sum=0;
                prefix[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxsum=Math.max(maxsum,largestRectangleArea(prefix[i]));
        }
        return maxsum;
    }
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int maxarea=0;
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int ele=arr[stack.peek()];
                stack.pop();
                int nse=i;
                int pse=stack.isEmpty() ? -1 : stack.peek();
                maxarea=Math.max(maxarea,ele*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse=arr.length;
            int ele=arr[stack.peek()];
            stack.pop();
            int pse=stack.isEmpty() ? -1 : stack.peek();
            maxarea=Math.max(maxarea,ele*(nse-pse-1));
        }
        return maxarea;
    }
}