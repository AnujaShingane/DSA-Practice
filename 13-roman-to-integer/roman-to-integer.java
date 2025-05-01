class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        if(s.isEmpty())return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = map.get(s.charAt(n-1));

        for(int i = s.length()-2 ; i >= 0 ; i--){
            if(map.get(s.charAt(i+1)) > map.get(s.charAt(i))){
                result -= map.get(s.charAt(i));
            }else if(map.get(s.charAt(i+1)) <= map.get(s.charAt(i))){
                result += map.get(s.charAt(i));
            }
        }

        return result;
    }
}