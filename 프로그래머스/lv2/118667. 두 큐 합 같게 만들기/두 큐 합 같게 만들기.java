import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> queueA=new LinkedList<>();
        Queue<Integer> queueB=new LinkedList<>();
        long sumA=0, sumB=0;
        for(int i=0;i<queue1.length;i++){
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
            sumA+=queue1[i];
            sumB+=queue2[i];
        }
        
        while(answer<1000000){
            if(sumA>sumB){
                sumA-=queueA.peek();
                sumB+=queueA.peek();
                queueB.add(queueA.poll());
            }
            else if(sumA<sumB){
                sumB-=queueB.peek();
                sumA+=queueB.peek();
                queueA.add(queueB.poll());
            }
            else return answer;
            answer++;
        }
        return -1;
    }
}