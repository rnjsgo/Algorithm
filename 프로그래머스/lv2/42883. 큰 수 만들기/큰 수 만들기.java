import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<number.length();i++){
            if(k!=0)
            {
                if(stack.size()==0) stack.push(Character.getNumericValue(number.charAt(i)));
                else{
                    while(stack.size()>0&&k>0&&stack.peek()<Character.getNumericValue(number.charAt(i))){
                        stack.pop();
                        k--;
                    }
                    stack.push(Character.getNumericValue(number.charAt(i)));
                }
            }
            else stack.push(Character.getNumericValue(number.charAt(i)));
            
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<stack.size()-k;i++)
            s.append(stack.get(i));
        return s.toString();
    }
}