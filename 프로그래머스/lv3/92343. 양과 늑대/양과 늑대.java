import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(list,0,0,0,info,edges);
        return answer;
    }
    public void dfs(List<Integer> list,int node,int count0,int count1,int[] info, int[][] edges){
        list.remove(Integer.valueOf(node));
        if(info[node]==0) count0++;
        else count1++;
       
        answer=Math.max(answer,count0);
        if(count0<=count1) return;
             
        for(int[] edge:edges){
            if(edge[0]==node) list.add(edge[1]);
        }
        
       for(int n:list){
           List<Integer> newList=new ArrayList<>(list);
           dfs(newList,n,count0,count1,info,edges);
       }
    }
}