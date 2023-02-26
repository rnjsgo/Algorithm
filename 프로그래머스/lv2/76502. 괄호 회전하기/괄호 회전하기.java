import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
             if(s.length()==1)
                    break;
            Stack<Character> stack=new Stack<>();
            boolean pass=true;
            s=s.substring(1,s.length())+String.valueOf(s.charAt(0));
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                if(c=='('||c=='['||c=='{')
                    stack.push(c);
                else if(c==')'){
                    if(stack.isEmpty()||stack.pop()!='('){
                        pass=false;
                        break;
                    }
                }
                else if(c=='}'){
                    if(stack.isEmpty()||stack.pop()!='{'){
                        pass=false;
                        break;
                    }
                }
                else {
                    if(stack.isEmpty()||stack.pop()!='['){
                        pass=false;
                        break;
                    }
                }
            }
            if(pass==true&&stack.isEmpty()) answer++;
        }
        return answer;
    }
}