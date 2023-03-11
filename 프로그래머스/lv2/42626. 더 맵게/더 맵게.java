import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> heap=new PriorityQueue<>();
        for(int n:scoville)
            heap.add(n);
        int answer = 0;
        while(heap.size()>1){
            int lowest=heap.poll();
            if(lowest>=K) return answer;
            else heap.add(lowest+heap.poll()*2);
            answer++;   
            if(heap.size()==1){
                if(heap.poll()>=K) return answer;
                else break;
            }
        }
        return -1;

    }
}