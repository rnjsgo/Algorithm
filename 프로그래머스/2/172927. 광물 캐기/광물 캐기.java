import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        for(int i=0; i<3; i++){
            if(picks[i] != 0) dfs(picks.clone(), i, 0, 0, minerals) ;
        }
        return answer;
    }
    
    public void dfs(int[] picks, int pick, int count, int sick, String[] minerals){
        picks[pick]--;
        boolean hasPick = false;
        
        for(int i=count; i<count+5 ; i++){
            if(i == minerals.length){
                answer = Math.min(sick, answer);
                return;
            }
            sick += work(pick, minerals[i]);
        }
        
        if(picks[0] != 0){
            dfs(picks.clone(), 0, count+5, sick, minerals);
            hasPick=true;
        }
        if(picks[1] != 0){
            dfs(picks.clone(), 1, count+5, sick, minerals);
            hasPick=true;
        }
        if(picks[2] != 0){
            dfs(picks.clone(), 2, count+5, sick, minerals);
            hasPick=true;
        }              
        
        if(!hasPick) answer = Math.min(sick, answer);
    }
    
    public int work(int pick, String mineral){
        if(pick == 0) return 1;
        else if(pick == 1){
            if(mineral.equals("diamond")) return 5;
            else return 1;
        }
        else{
            if(mineral.equals("diamond")) return 25;
            else if(mineral.equals("iron")) return 5;
            else return 1;
        }
    }
}