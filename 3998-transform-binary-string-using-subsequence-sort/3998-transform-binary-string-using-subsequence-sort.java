class Solution {

    public boolean[] transformStr(String s, String[] strs) {

        int n = s.length();

        int zeroS = 0;
        int oneS = 0;

        // Count 0s and 1s in s
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeroS++;
            } else {
                oneS++;
            }
        }

        boolean[] ans = new boolean[strs.length];

        for (int k = 0; k < strs.length; k++) {

            char[] str = strs[k].toCharArray();

            int zeroStr = 0;
            int oneStr = 0;

            // Count fixed 0s and 1s
            for (char ch : str) {
                if (ch == '0') {
                    zeroStr++;
                } else if (ch == '1') {
                    oneStr++;
                }
            }

            // Number of 0s and 1s that '?' must become
            int needZero = zeroS - zeroStr;
            int needOne = oneS - oneStr;

            // Not enough '?' to match the number of 0s/1s
            if (needZero < 0 || needOne < 0) {
                ans[k] = false;
                continue;
            }

            /*
             * Put required 0s in the LEFTMOST '?' positions.
             * Remaining '?' become 1.
             */
            for (int i = 0; i < n && needZero > 0; i++) {

                if (str[i] == '?') {
                    str[i] = '0';
                    needZero--;
                }
            }

            for (int i = 0; i < n && needOne > 0; i++) {

                if (str[i] == '?') {
                    str[i] = '1';
                    needOne--;
                }
            }

            // Check prefix condition
            int onesInS = 0;
            int onesInStr = 0;

            boolean possible = true;

            for (int i = 0; i < n; i++) {

                if (s.charAt(i) == '1') {
                    onesInS++;
                }

                if (str[i] == '1') {
                    onesInStr++;
                }

                // Target cannot have more 1s in any prefix
                if (onesInStr > onesInS) {
                    possible = false;
                    break;
                }
            }

            ans[k] = possible;
        }

        return ans;
    }
}