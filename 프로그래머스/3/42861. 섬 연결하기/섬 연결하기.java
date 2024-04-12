import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        for(int[] cost : costs){
            if(count == n - 1) break;
            int land1 = cost[0];
            int land2 = cost[1];
            int parent1 = findParent(land1);
            int parent2 = findParent(land2);
            
            if(parent1 == parent2) continue;
            else{
                parent[parent2] = parent1;
                count ++;
                answer += cost[2];
            }
        }
        return answer;
    }
    
    public int findParent(int node){
        if(parent[node] == node) return node;
        else return findParent(parent[node]);
    }
}