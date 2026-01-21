class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list1 = new ArrayList<>();
        for(int[] arr : intervals){
            list1.add(arr);
        }
        list1.add(newInterval);

        Collections.sort(list1,(a,b) -> a[0]-b[0]);

        List<int[]> list2 = new ArrayList<>();
        list2.add(list1.get(0));
        int last = list1.get(0)[1];

        for(int i = 1 ; i < list1.size() ; i++){
            if(list1.get(i)[0]<=last){
                list2.get(list2.size()-1)[1] = Math.max(list2.get(list2.size()-1)[1],list1.get(i)[1]);
                last = list2.get(list2.size() - 1)[1];
            }else if(list1.get(i)[0]<=last && list1.get(i)[1]<=last){

            }else{
                list2.add(list1.get(i));
                last = list1.get(i)[1];
            }
        }

        int[][] res = new int[list2.size()][2];
        for(int i = 0 ; i < list2.size() ; i++){
            res[i] = list2.get(i);
        }
        return res;
    }
}