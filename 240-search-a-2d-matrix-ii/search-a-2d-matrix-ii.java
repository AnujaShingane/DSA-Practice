class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        for(int i = 0 ; i < row ; i++){
            if(binarySearch(matrix[i],target) == true){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}