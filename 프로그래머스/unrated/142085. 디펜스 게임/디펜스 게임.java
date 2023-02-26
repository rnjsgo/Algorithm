import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer=0;
        Queue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int i=0;
        while(true){
            if(i==enemy.length) break;
            n-=enemy[i];
            pq.add(enemy[i]);
            if(n<0&&k>0&&!pq.isEmpty()){
                n+=pq.poll();
                k--;
            }
            if(n>=0){
                i++;
                answer++;
            }
            if(n<=0&&k==0) break;
        }
        return answer;
    }
}