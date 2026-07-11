import java.util.Collections;    

class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;
        int[][] arr = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = s[i];
            arr[i][1] = f[i];
            arr[i][2] = i+1;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        int last = arr[0][1];
        
        int cnt = 1;
        
        for(int i = 0 ; i < n ; i++){
            int[] threearr = arr[i];
            if(i==0)list.add(threearr[2]);
            int start = threearr[0];
            int end = threearr[1];
            int meeting = threearr[2];
            
            if(start > last){
                cnt++;
                last = end;
                list.add(meeting);
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
}