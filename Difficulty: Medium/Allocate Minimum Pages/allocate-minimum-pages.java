class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if(k>n)return -1;
        
        int low = Integer.MIN_VALUE; // max in array
        int high = 0; // sum of array
        
        for(int num : arr){
            low = Math.max(low,num);
            high+=num;
        }
        
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int noStudents = students(arr,mid);
            
            if(noStudents<=k){
                ans = mid;
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public static int students(int[] arr, int maxPages){
        int n = arr.length;
        int student = 1;
        int sum = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(sum+arr[i]>maxPages){
                student++;
                sum=arr[i];
            }else{
                sum+=arr[i];
            }
        }
        
        return student;
    }
}