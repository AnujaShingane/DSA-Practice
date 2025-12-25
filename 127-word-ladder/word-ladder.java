class Pair{
    String s;
    int level;

    Pair(String s , int level){
        this.s = s;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String st : wordList){
            set.add(st);
        }
        set.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String st = p.s;
            int level = p.level;
            if(st.equals(endWord))return level;

            for(int i = 0 ; i < st.length() ; i++){
                for(char j = 'a' ; j <= 'z' ; j++){
                    char[] chArr = st.toCharArray();
                    chArr[i]=j;
                    String replacedString = new String(chArr);
                    if(set.contains(replacedString)){
                        set.remove(replacedString);
                        q.add(new Pair(replacedString,level+1));
                    }
                }
            }
        }
        return 0;
    }
}