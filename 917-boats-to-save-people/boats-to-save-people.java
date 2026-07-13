class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        if(n==1 && people[0]<=limit)return 1;
        int i = 0;
        int j = n-1;

        int cnt = 0;
        while(i<=j){
            int ith = people[i];
            int jth = people[j];
            int sum = people[i]+people[j];

            if(ith+jth>limit){
                cnt++;
                j--;
            }else{
                cnt++;
                i++;
                j--;
            }
        }

        return cnt;
    }
}