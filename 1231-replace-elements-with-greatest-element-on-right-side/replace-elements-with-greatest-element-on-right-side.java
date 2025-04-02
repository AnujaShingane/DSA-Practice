class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[arr.length];
        ArrayList<Integer> list = new ArrayList<>();

        list.add(-1);
        int max = arr[n-1];
        for(int i = arr.length-2 ; i >= 0 ; i--){
            list.add(max);
            max = Math.max(max,arr[i]);
        }

        int j = 0;
        for(int i = list.size()-1 ; i >= 0 ; i--){
            result[j++] = list.get(i);
        }

        return result;
    }
}