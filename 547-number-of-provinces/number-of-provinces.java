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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n+1);

        for(int i = 0 ; i < n ; i++){
            int node = i+1;
            for(int j = 0 ; j < isConnected[0].length ; j++){
                if(isConnected[i][j]==1)ds.unionByParent(node,j+1);
            }
        }

        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            if(ds.findUPar(i) == i){
                cnt++;
            }
        }

        return cnt;
    }
}