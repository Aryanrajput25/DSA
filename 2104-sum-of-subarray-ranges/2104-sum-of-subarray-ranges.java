class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
    public long sumSubarrayMaxs(int[] arr) {
        int[] nge=nge(arr);
        int[] pgee=pgee(arr);
        long total =0;
        for(int i=0;i<arr.length;i++){
            int left=i-pgee[i];
            int right=nge[i]-i;
            total += (long) left * right * arr[i];
        }
        return total;
    }
    public int[] nge(int[] arr){
        int[] nge=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
            nge[i]=stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nge;
    }
    public int[] pgee(int[] arr){
        int[] pgee=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) stack.pop();
            pgee[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pgee;
    }
    public long sumSubarrayMins(int[] arr) {
        int[] nse=nse(arr);
        int[] psee=psee(arr);
        long total =0;
        for(int i=0;i<arr.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total += (long) left * right * arr[i];
        }
        return total;
    }
    public int[] nse(int[] arr){
        int[] nse=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            nse[i]=stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    public int[] psee(int[] arr){
        int[] psee=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            psee[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }
}