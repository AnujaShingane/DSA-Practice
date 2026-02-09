class Pair{
    int[] arr;
    int dist;

    Pair(int[] arr, int dist){
        this.arr = arr;
        this.dist = dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int m = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist-b.dist
        );

        for(int[] pt : points){
            int x = pt[0];
            int y = pt[1];

            int dis = x*x + y*y;

            pq.add(new Pair(pt,dis));
        }


        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            Pair pair = pq.poll();

            res[i][0]=pair.arr[0];
            res[i][1]=pair.arr[1];
        }

        return res;
    }
}