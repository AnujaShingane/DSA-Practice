class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        int x = a;
        int y = b;
    
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        int gcd = a;
        
        int lcm = x / gcd * y;
        
        return new int[]{lcm,gcd};
    }
}