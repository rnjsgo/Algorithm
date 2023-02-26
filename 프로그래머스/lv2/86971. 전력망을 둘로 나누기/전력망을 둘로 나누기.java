import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;    
        
        for(int i=0;i<wires.length;i++){
            ArrayList<Integer> visited=new ArrayList<>();
            dfs(n,i,wires[i][0],wires,visited);
            answer=Math.min(answer,Math.abs(2*visited.size()-n));
        }
        return answer;
    }
    public void dfs(int n,int cut,int check,int[][] wires,ArrayList<Integer> visited){
        visited.add(check);
        for(int i=0;i<wires.length;i++){
            if(i==cut) continue;
            if(wires[i][0]==check&&!visited.contains(wires[i][1]))
                dfs(n,cut,wires[i][1],wires,visited);
            else if(wires[i][1]==check&&!visited.contains(wires[i][0])){
                dfs(n,cut,wires[i][0],wires,visited);
            }
        }     
    }           
}