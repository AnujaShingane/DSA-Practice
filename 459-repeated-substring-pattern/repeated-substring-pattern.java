class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Remove first and last char to avoid trivial match
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }
}
