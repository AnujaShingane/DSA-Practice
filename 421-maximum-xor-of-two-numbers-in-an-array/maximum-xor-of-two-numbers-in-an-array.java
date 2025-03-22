class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for(int i=31;i>=0;i--){
            //The progression of masks will be 1000..,1100..,1110...,1111....
            mask = mask | (1 << i); 
            Set<Integer> set = new HashSet<>();

            //Taking only first i bits
            //We need to find A ^ B = C such as C is maximum.
            //In Set we are adding our A's
            for(int num : nums){
                set.add(num & mask);
            }

            //Trying a new max by enabling new ith bit.
            //This is our C.
            int tryNewMax = max | (1 << i);
            for(int firstele : set){

                //Trying that if A ^ C which is B exists or not in the set.
                //Because if we find the B, then A ^ C = B which is equal to A ^ B = C
                //So There exists a B such that We can make A ^ B = C
                //Set that new max to max.
                if(set.contains(firstele ^ tryNewMax)){
                    max = tryNewMax;
                    break;
                }
            }

            //We are bit by bit assuming a new max by enabling bits from MSB to LSB one by one.
            //And checking whether that assumed max is possible or not with set.
        }

        return max;
    }
}