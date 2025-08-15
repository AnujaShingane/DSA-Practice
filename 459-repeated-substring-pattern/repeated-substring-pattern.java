class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s+s;
        String str = doubled.substring(1,doubled.length()-1);
        return str.contains(s);
    }
}