import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanhoScore=scores[0][0]+scores[0][1];
        int[] wanho=scores[0];
        
        Arrays.sort(scores,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        int max=scores[0][1];
        
        for(int i=0;i<scores.length;i++){
            if(scores[i][1]<max){
                if(scores[i][0]==wanho[0]&&scores[i][1]==wanho[1]) return -1;
                scores[i][0]=-100001;
            }
            if(scores[i][0]+scores[i][1]>wanhoScore) answer++;
            max=Math.max(max,scores[i][1]);
        }
        
        return answer;
    }
}