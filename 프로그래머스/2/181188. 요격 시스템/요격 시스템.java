import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> {
            return (a[0] == b[0])? a[1] - b[1] : a[0] - b[0];
        });
        
        for(int i=0; i<targets.length; i++){
            answer++;
            int position = targets[i][1];
            
            while(i < targets.length - 1 && targets[i+1][0] < position){
                if(position > targets[i+1][1]) position = targets[i+1][1];
                i++;
            }
        }
        return answer;
    }
}