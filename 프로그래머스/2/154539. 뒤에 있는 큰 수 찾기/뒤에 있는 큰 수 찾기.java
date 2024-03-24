import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = numbers.length-1; i>=0; i--){
            while(true){
                if(stack.empty()){
                    answer[i] = -1 ;
                    stack.push(numbers[i]);
                    break;
                }
                if(numbers[i] >= stack.peek()) stack.pop();
                else{
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                    break;
                }
            }
        }
        return answer;
    }
}