class Solution {
    public boolean isHappy(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int ans = 0;
        HashSet<String> set = new HashSet<>(); 
        while(!s.equals("1") && !set.contains(s)){
            set.add(s);

            for(char ch : s.toCharArray()){
                int  num = ch - '0';
                ans += num * num;
            }
            sb.append(ans);
            s = sb.toString();
            ans = 0;
            sb.setLength(0);
        }

        return s.equals("1");
    }
}