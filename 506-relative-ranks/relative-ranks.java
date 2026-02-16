class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] dummy = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            dummy[i] = score[i];
        }
        HashMap<Integer,String> map = new HashMap<>();

        Arrays.sort(dummy, Collections.reverseOrder());
        for(int i = 0 ; i < n ; i++){
            if(i==0){
                map.put(dummy[i],"Gold Medal");
            }else if(i==1){
                map.put(dummy[i],"Silver Medal");
            }else if(i==2){
                map.put(dummy[i],"Bronze Medal");
            }else{
                int position = i+1;
                String str = String.valueOf(position);

                map.put(dummy[i],str);
            }
        }

        String[] res = new String[n];
        for(int i = 0 ; i < n ; i++){
            int num = score[i];
            String s = map.get(num);

            res[i] = s;
        }

        return res;
    }
}