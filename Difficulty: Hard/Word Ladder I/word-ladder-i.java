class Pair{
    String s;
    int level;
    
    Pair(String s, int level){
        this.s = s;
        this.level = level;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        Set<String> set = new HashSet<>();
        for(String st : wordList)set.add(st);
        set.remove(startWord);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            String st = p.s;
            int level = p.level;
            if(st.equals(targetWord))return level;
            
            for(int i = 0 ; i < st.length() ; i++){
                for(char j='a' ; j <= 'z' ; j++){
                    char[] chArr = st.toCharArray();
                    chArr[i]=j;
                    String replacedString = new String(chArr);
                    if(set.contains(replacedString)){
                        q.add(new Pair(replacedString,level+1));
                        set.remove(replacedString);
                    }
                }
            }
        }
        return 0;
    }
}