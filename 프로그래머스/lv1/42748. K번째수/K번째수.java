import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] tmpArr=array.clone();
            Arrays.sort(tmpArr,commands[i][0]-1,commands[i][1]);
            answer[i]=tmpArr[commands[i][0]+commands[i][2]-2];
        }
        return answer;
    }
}