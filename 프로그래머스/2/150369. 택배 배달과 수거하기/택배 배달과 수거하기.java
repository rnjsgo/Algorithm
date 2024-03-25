import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        
        for(int i=0; i<n; i++){
            deliveryStack.push(deliveries[i]);
            pickupStack.push(pickups[i]);
        }
        
        while(!deliveryStack.isEmpty() || !pickupStack.isEmpty()){
            answer += Math.max(delivery(deliveryStack, cap), delivery(pickupStack, cap));
        }
        return answer * 2;
    }
    
    public int delivery(Stack<Integer> stack, int cap){
        boolean findLast = false;
        int distance = 0;
        
        while(!stack.isEmpty() && cap > 0){
            if(stack.peek() != 0){
                if(!findLast){
                    distance = stack.size();
                    findLast = true;
                }
                
                if(stack.peek() <= cap){
                    cap -= stack.pop();
                }
                else{
                    stack.push(stack.pop() - cap);
                    break;
                }
            }
            else stack.pop();
        }
        
        return distance;
    }
}