import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum=0;

        Queue<Integer> trucks=new LinkedList<>();
        Queue<Integer> onBridge = new LinkedList<>();
        for(int n:truck_weights)
            trucks.add(n);
    
        while(!trucks.isEmpty()){
            answer++;
            if(onBridge.size()==bridge_length)
                weightSum-=onBridge.poll();

            if(onBridge.isEmpty()){
                weightSum+=trucks.peek();
                onBridge.add(trucks.poll());
            }
            else if(weightSum+trucks.peek()<=weight){
                weightSum+=trucks.peek();
                onBridge.add(trucks.poll());
            }
            else onBridge.add(0);
        }
        return answer+bridge_length;
    }
}