 import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum=0;

        Queue<Integer> trucks=new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for(int n:truck_weights)
            trucks.add(n);
    
        while(!trucks.isEmpty()){
            answer++;
            if(bridge.size()==bridge_length)
                weightSum-=bridge.poll();

            if(bridge.isEmpty()){
                weightSum+=trucks.peek();
                bridge.add(trucks.poll());
            }
            else if(weightSum+trucks.peek()<=weight){
                weightSum+=trucks.peek();
                bridge.add(trucks.poll());
            }
            else bridge.add(0);
        }
        return answer+bridge_length;
    }
}