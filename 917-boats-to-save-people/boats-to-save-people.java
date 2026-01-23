class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int sum = 0;
        int i = 0;
        int j = n-1;
        int cnt = 0;

        while(i<=j){
            sum = people[i]+people[j];

            if(sum>limit){
                cnt++;
                j--;
            }else{
                cnt++;
                i++;
                j--;
            }
            sum=0;
        }

        return cnt;
    }
}