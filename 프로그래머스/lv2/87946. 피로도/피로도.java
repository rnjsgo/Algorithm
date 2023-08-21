import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length ; i++){
            boolean[] visited = new boolean[dungeons.length];
            dfs(k,i,1,visited,dungeons);
        }
        return answer;
    }
    
    public void dfs(int health, int index, int depth, boolean[] visited, int[][] dungeons){
        visited[index] = true;
        answer = Math.max(answer,depth);
        health = health - dungeons[index][1];
        
        for(int i=0; i<dungeons.length;i++){
            if(!visited[i] && health >= dungeons[i][0] && health >= dungeons[i][1]){
                boolean[] visit = visited.clone();
                dfs(health, i, depth+1, visit, dungeons);
            }
        }
    }
}