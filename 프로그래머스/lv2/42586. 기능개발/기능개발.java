import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result=new ArrayList<>();

        int index=0;
        while(index<progresses.length){
            int count=0;
            int day=(100-progresses[index])/speeds[index];
            if((100-progresses[index])%speeds[index]!=0)
                day++;  
            for(int i=index;i<progresses.length;i++){
                progresses[i]+=day*speeds[i];
            }
            for(int i=index;i<progresses.length;i++){
                if(progresses[i]>=100){
                    index++;
                    count++;
                }
                else break;
            }
            result.add(count);
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++)
            answer[i]=result.get(i);
            
        return answer;
    }
}