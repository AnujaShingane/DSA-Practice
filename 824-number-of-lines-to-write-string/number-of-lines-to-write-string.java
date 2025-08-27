class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        if (s == null || s.length() == 0) return new int[]{0, 0};
        int lines = 1;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a']; 
            if (sum + w > 100) {       
                lines++;
                sum = w;               
            } else {
                sum += w;
            }
        }
        return new int[]{lines, sum};
    }
}