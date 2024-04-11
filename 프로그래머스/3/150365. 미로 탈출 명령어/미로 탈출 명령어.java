import java.util.*;

class Solution {
    boolean find;
    String answer = "impossible";
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] location = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs("", n, m, x, y, r, c, k);
        return answer;
    }
    
    public void dfs(String sentence, int n, int m, int x, int y, int r, int c, int k){
        if(x == r && y == c && sentence.length() == k){
            answer = sentence;
            find = true;
            return;
        }
        if(find) return;
        if(sentence.length() > k) return;
        int distance = Math.abs(r - x) + Math.abs(c - y);
        int chance = (k - sentence.length()) - distance;
        if(chance < 0 || chance % 2 == 1) return;   
        
        
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX > 0 && nextX <= n && nextY > 0 && nextY <= m) 
                dfs(sentence + location[i], n, m, nextX, nextY, r, c, k);
        }
    }
}