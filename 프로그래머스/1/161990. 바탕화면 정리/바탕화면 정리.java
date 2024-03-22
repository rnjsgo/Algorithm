import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] wp = new char[wallpaper.length][wallpaper[0].length()];
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int i =0 ; i<wp.length ; i++){
            wp[i] = wallpaper[i].toCharArray();
        }
        
        for(int i = 0 ; i<wp.length ; i++){
            for(int j =0 ; j<wp[0].length ; j++){
                if(wp[i][j]=='#'){
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                }
            }
        }
        
        int[] answer = {minX, minY, maxX+1, maxY+1};
        return answer;
    }
}