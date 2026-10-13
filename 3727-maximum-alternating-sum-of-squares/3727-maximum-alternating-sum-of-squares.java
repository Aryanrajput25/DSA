class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        long sum=0;
        int n=nums.length;
        for(int i=n/2;i<n;i++){
            long num=arr[i]*arr[i];
            sum+=num;
        }
        for(int i=0;i<n/2;i++){
            long num=arr[i]*arr[i];
            sum-=num;
        }
        return sum;
    }
}