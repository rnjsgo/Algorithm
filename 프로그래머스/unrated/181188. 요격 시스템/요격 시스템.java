import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int index=0;
        int last;
        Arrays.sort(targets,(a,b)->a[0]-b[0]);
        while(index<targets.length){
            last=targets[index][1];
            answer++;
            while(index<targets.length&&targets[index][0]<last){
                if(targets[index][1]<last) last=targets[index][1];
                index++;
            }
        }
        return answer;
    }
}