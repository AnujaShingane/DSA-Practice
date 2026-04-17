class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        int flag = 0;
        for(int num : nums){
            if(num!=0){
                flag = 1;
            }
        }
        if(flag==0)return "0";

        List<String> list = new ArrayList<>();
        for(int num : nums){
            String s = String.valueOf(num);
            list.add(s);
        }

        Collections.sort(list,(a,b)->(b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }

        return sb.toString();
    }
}