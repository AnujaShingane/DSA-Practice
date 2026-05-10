import java.util.*;

class DisjointSet{
  ArrayList<Integer> rank = new ArrayList<>();
  ArrayList<Integer> parent = new ArrayList<>();
  
  DisjointSet(int n){
    for(int i = 0 ; i <= n ; i++){
      rank.add(0);
      parent.add(i);
    }
  }
  
  public int findUPar(int node){
    if(node == parent.get(node))return node;
    
    int ulp = findUPar(parent.get(node));
    parent.set(node,ulp);
    return parent.get(node);
  }
  
  public void unionByParent(int u , int v){
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    
    if(ulp_v==ulp_u)return;
    
    if(rank.get(ulp_u)<rank.get(ulp_v)){
      parent.set(ulp_u,ulp_v);
    }else if(rank.get(ulp_u)>rank.get(ulp_v)){
      parent.set(ulp_v,ulp_u);
    }else{
      parent.set(ulp_u,ulp_v);
      rank.set(ulp_u,rank.get(ulp_u)+1);
    }
  }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < accounts.get(i).size() ; j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ds.unionByParent(map.get(accounts.get(i).get(j)),i);
                }
                map.put(accounts.get(i).get(j),i);
            }
        }

        HashMap<Integer,List<String>> map2 = new HashMap<>();
        for(String key : map.keySet()){
            int value = map.get(key);
            int par = ds.findUPar(value);
            
            map2.putIfAbsent(par,new ArrayList<>());
            map2.get(par).add(key);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if (!map2.containsKey(i))
                continue;
            List<String> mails = map2.get(i);
            Collections.sort(mails);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mails);
            res.add(temp);
        }

        return res;
    }
}