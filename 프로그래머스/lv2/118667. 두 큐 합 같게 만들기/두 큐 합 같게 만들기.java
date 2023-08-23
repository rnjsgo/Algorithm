import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();
        long sumA=0 ,sumB=0;
        for(int i=0; i<queue1.length; i++){
            a.add(queue1[i]);
            b.add(queue2[i]);
            sumA+=queue1[i];
            sumB+=queue2[i];
        }
        
        while(sumA!=sumB){
            if(answer>10000000) return -1;
                
            if(sumA>sumB){
                sumB+=a.peek();
                sumA-=a.peek();
                b.add(a.poll());
            }
            else{
                sumA+=b.peek();
                sumB-=b.peek();
                a.add(b.poll());
            }
            
            answer++;
        }
        return answer;
    }
}