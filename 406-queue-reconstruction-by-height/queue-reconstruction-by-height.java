class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = people[i][j];
            }
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }else{
                return a[1]-b[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int[] ar = arr[i];
            list.add(ar[1],new int[]{ar[0],ar[1]});
        }

        for(int i = 0 ; i < n ; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}