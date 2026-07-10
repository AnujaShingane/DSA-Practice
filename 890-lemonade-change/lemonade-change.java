class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fives = 0;
        int tens = 0;
        int twtys = 0;

        for(int i = 0 ; i < n ; i++){
            if(bills[i]==5)fives++;
            else if(bills[i]==10){
                if(fives>=1){
                    tens++;
                    fives--;
                }else{
                    return false;
                }
            }
            else if(bills[i]==20){
                if(tens>=1 && fives>=1){
                    twtys++;
                    tens-=1;
                    fives-=1;
                }else if(fives>=3){
                    twtys++;
                    fives-=3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}