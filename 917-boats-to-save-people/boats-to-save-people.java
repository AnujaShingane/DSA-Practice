class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int sum=0;
        int cnt =0;

        while(i<=j){
            sum = people[i]+people[j];
            if(sum<=limit){
                cnt++;
                i++;
                j--;
            }else{
                cnt++;
                j--;
            }
            sum=0;
        }
        return cnt;
    }
}