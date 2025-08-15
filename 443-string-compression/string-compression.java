class Solution {
    public int compress(char[] chars) {
        int i = 0; // write pointer
        int j = 0; // read pointer
        int n = chars.length;

        while (j < n) {
            char ch = chars[j];
            int start = j;
            
            // Move j until a different char is found
            while (j < n && chars[j] == ch) {
                j++;
            }

            // Write the character
            chars[i++] = ch;

            // Write the count if > 1
            int count = j - start;
            if (count > 1) {
                String cntStr = String.valueOf(count);
                for (char c : cntStr.toCharArray()) {
                    chars[i++] = c;
                }
            }
        }
        return i;
    }
}