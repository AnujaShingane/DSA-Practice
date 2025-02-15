class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        
        // Convert to ArrayLists of Integers
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        
        for (String part : v1Parts) v1.add(Integer.parseInt(part));
        for (String part : v2Parts) v2.add(Integer.parseInt(part));         
        
        // Find the max length
        int maxLength = Math.max(v1.size(), v2.size());

        // Compare each version part
        for (int i = 0; i < maxLength; i++) {
            // int num1 = (i < v1.size()) ? v1.get(i) : 0;
            // int num2 = (i < v2.size()) ? v2.get(i) : 0;

            int num1 , num2;

            if(i < v1.size()){
                num1 = v1.get(i);
            }else{
                num1 = 0;
            }

            if(i < v2.size()){
                num2 = v2.get(i);
            }else{
                num2 = 0;
            }

            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        
        return 0;
    }
}