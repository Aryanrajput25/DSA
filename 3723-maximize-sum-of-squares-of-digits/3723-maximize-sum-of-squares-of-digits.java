class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";

        StringBuilder sb = new StringBuilder();

        while (num-- > 0) {
            int digit = Math.min(sum, 9);
            sb.append(digit);
            sum -= digit;
        }

        return sb.toString();
    }
}