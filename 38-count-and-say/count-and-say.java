class Solution {
    String ans;
    public String countAndSay(int n) {
        String prevAns = "1";
        if(n == 1){
            return "1";
        }
        for(int i = 0 ; i < n-1 ; i++){
            ans = RLE(prevAns);
            prevAns = ans;
        }

        return ans;
    }

    public String RLE(String str){
        int n = str.length();
        char[] arr = str.toCharArray();

        char mch = arr[0];
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i < n ; i++){
            if(arr[i] == mch){
                cnt++;
            }else{
                sb.append(cnt);
                sb.append(mch);

                mch = arr[i];
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(mch);

        return sb.toString();
    }
}