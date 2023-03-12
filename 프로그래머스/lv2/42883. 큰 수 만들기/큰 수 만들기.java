import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty()&&k>0&&stack.peek()<number.charAt(i)){
                    k--;
                    stack.pop();
            }
            stack.push(number.charAt(i));            
        }
        for(int i=0;i<stack.size()-k;i++)
            answer.append(stack.get(i));
        return answer.toString();
    }
}