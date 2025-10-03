class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int rem=0;

        while(i>=0 && j>=0){
            int n1=num1.charAt(i)-'0';
            int n2=num2.charAt(j)-'0';
            int sum=n1+n2+rem;
            sb.append((char) ('0' + (sum % 10)));
            rem=sum/10;
            i--;
            j--;
        }

        while(i>=0){
            int sum = (num1.charAt(i)-'0')+rem;
            sb.append((char) ('0' + (sum % 10)));
            rem=sum/10;
            i--;
        }

        while(j>=0){
            int sum = (num2.charAt(j)-'0')+rem;
            sb.append((char) ('0' + (sum % 10)));
            rem=sum/10;
            j--;
        }
        if (rem > 0) sb.append((char) ('0' + rem));
        return sb.reverse().toString();
    }
}