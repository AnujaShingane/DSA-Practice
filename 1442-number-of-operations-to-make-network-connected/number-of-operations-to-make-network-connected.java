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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;

        for(int[] arr : connections){
            int u = arr[0];
            int v = arr[1];

            if(ds.findUPar(u)==ds.findUPar(v)){
                cntExtras++;
            }else{
                ds.unionByParent(u,v);
            }
        }

        int cntC = 0;
        for(int i = 0 ; i < n ; i++){
            if(ds.findUPar(i)==i){
                cntC++;
            }
        }

        int ans = cntC-1;
        if(cntExtras >= ans)return ans;
        else return -1;
    }
}