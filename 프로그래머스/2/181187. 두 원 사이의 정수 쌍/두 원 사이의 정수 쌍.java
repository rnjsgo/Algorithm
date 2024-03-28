import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i=0; i<r2; i++){
            double inR2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            double inR1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            
            if(inR1%1 == 0 && inR1 != 0) answer ++;
            answer += (int)inR2 - (int)inR1;
        }
        return answer * 4;
    }
}