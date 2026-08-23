class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            if (i < half) {
                if (c == '?')
                    leftQ++;
                else
                    leftSum += c - '0';
            } else {
                if (c == '?')
                    rightQ++;
                else
                    rightSum += c - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        // Alice wins if the final sums cannot be made equal
        if (qDiff % 2 != 0)
            return true;

        return diff + (qDiff / 2) * 9 != 0;
    }
}