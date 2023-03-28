import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int countI=0, countD=0;
        Queue<Integer> minHeap=new PriorityQueue<>();
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(String s:operations){
            if(s.split(" ")[0].equals("I")){
                if(countI==countD){
                    minHeap.clear();
                    maxHeap.clear();
                }
                minHeap.add(Integer.parseInt(s.split(" ")[1]));
                maxHeap.add(Integer.parseInt(s.split(" ")[1]));
                countI++;
            }
            else{
                if(countI==countD) continue;
                else{
                    if(s.split(" ")[1].equals("1")) maxHeap.poll();
                    else minHeap.poll();
                    countD++;
                }
            }
        }
        if(countI==countD){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0]=maxHeap.poll();
            answer[1]=minHeap.poll();
        }
        return answer;
    }
}