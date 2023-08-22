class Solution {
    static int maxDifference = 0;
    static int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(n , lion, info, 0, 10);
        if(maxDifference <= 0){
         int[] neverWin = {-1};
            return neverWin;
        }

        return answer;
    }
    
    public void dfs(int arrows, int[] lion, int[] apeach, int difference, int score){
        if(score < 0){
            if(arrows>0) lion[10] = arrows;
            if(difference>maxDifference){
                maxDifference = difference;
                answer = lion;
            }
            if(difference==maxDifference){
                for(int i=10; i>=0; i--){
                    if(lion[i]>answer[i]){
                        answer = lion;
                        return;
                    }
                    if(lion[i]<answer[i]){
                        return;
                    }
                }
            }
            return ;
        }
        // 이기는 경우
        if(arrows>apeach[10-score]){
            int arrow = apeach[10-score] + 1;
            int[] newLion = lion.clone();
            newLion[10-score] = arrow;
            dfs(arrows-arrow, newLion, apeach, difference + score, score - 1);
        }
        
        // 비기는 경우
        if(score>0 && apeach[10-score] == 0){
            int[] newLion = lion.clone();
            newLion[10-score] = 0;
            dfs(arrows, newLion, apeach, difference, score - 1);
        }
        
        // 지는 경우
        int arrow = apeach[10-score] + 1;
        int[] newLion = lion.clone();
        newLion[10-score] = 0;
        dfs(arrows, newLion, apeach, difference - score, score - 1);
    }
}