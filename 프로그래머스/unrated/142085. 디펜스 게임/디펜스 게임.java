import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue=new PriorityQueue<>((a,b)->b-a);

        while(answer<enemy.length){
            n-=enemy[answer];
            queue.add(enemy[answer]);
            if(n<0){
                if(!queue.isEmpty()&&k>0){
                    n+=queue.poll();
                    k--;
                }
                else break;
            }
            answer++;
        }
        return answer;
    }
}