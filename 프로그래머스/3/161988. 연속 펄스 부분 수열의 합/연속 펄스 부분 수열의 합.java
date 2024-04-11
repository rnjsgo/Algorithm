import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int startPos = 1;
        int startNeg = -1;
        long startPosMax = 0, startNegMax = 0; 
        long answer = Long.MIN_VALUE;
        
        for(int s : sequence){
            int startPosNum = s * startPos;
            int startNegNum = s * startNeg;
            startPosMax = (startPosMax + startPosNum > startPosNum)? startPosMax + startPosNum : startPosNum;
            startNegMax = (startNegMax + startNegNum > startNegNum)? startNegMax + startNegNum : startNegNum;
            
            answer = Math.max(answer, Math.max(startPosMax, startNegMax));
            startPos *= -1;
            startNeg *= -1;
        }
        
        return answer;
    }
}