import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        
        for(int i=1;i<prices.length;i++){
            while(!stack.isEmpty()&&prices[stack.peek()]>prices[i]){
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        int num=prices.length-1;
        for(int i=0;i<prices.length;i++){
            if(answer[i]==0)
                answer[i]=num;
            num--;
        }
        return answer;
    }
}