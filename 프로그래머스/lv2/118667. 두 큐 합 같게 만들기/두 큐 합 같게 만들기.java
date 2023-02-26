import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> queueA=new LinkedList<>();
        Queue<Integer> queueB=new LinkedList<>();
        long queue1Sum=0;
        long queue2Sum=0;
        int maxCount=queue1.length*4;
        int answer=maxCount;
        int count=0;
        for(int i=0;i<queue1.length;i++){
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
            queue1Sum+=queue1[i];
            queue2Sum+=queue2[i];
        }
        long half=(queue1Sum+queue2Sum)/2;
        if((queue1Sum+queue2Sum)%2!=0) return -1;
        
        while(count<=maxCount){
            if(queue1Sum==half){
                answer=count;
                break;
            }
            if(queue1Sum>half&&queueA.size()>0){
                int item=queueA.poll();
                queueB.add(item);
                queue1Sum-=item;
                count++;
            }
            else if(queue1Sum<half&&queueB.size()>0){
                int item=queueB.poll();
                queueA.add(item);
                queue1Sum+=item;
                count++;
            }
        }
        if(answer==maxCount) return -1;
        return answer;
    }

}