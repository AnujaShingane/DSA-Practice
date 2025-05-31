class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            int smallest = i;
            
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}