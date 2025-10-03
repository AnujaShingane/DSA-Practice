class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < order.length() ; i++){
            while(arr[order.charAt(i)-'a']!=0){
                sb.append(order.charAt(i));
                arr[order.charAt(i)-'a']--;
            }
        }

        for(char c = 'a' ; c <= 'z' ; c++){
            while(arr[c-'a']!=0){
                sb.append(c);
                arr[c-'a']--;
            }
        }

        return sb.toString();
    }
}