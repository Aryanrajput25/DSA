class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Try to match target
        int i = 0;

        while (i < n) {

            int idx = target.charAt(i) - 'a';

            if (count[idx] > 0) {
                count[idx]--;
                i++;
            } else {
                break;
            }
        }

        // Backtrack
        int start = Math.min(i, n - 1);

        for (int j = start; j >= 0; j--) {

            // Restore character at position j
            if (j < i) {
                count[target.charAt(j) - 'a']++;
            }

            int targetChar = target.charAt(j) - 'a';

            // Find smallest character greater than target[j]
            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Keep prefix same
                    for (int k = 0; k < j; k++) {
                        ans.append(target.charAt(k));
                    }

                    // Put greater character
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Put remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}