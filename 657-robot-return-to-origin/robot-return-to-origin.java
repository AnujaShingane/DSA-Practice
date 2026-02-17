class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int[] coor = new int[2];
        coor[0]=0;
        coor[1]=0;

        for(int i = 0 ; i < n ; i++){
            char ch = moves.charAt(i);

            if(ch=='U')coor[1]++;
            else if(ch=='D')coor[1]--;
            else if(ch=='R')coor[0]++;
            else if(ch=='L')coor[0]--;
        }

        if(coor[0]==0 && coor[1]==0)return true;
        return false;
    }
}