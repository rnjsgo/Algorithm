import java.util.*;
class Solution {
    public int solution(int[] order) {
        Queue<Integer> main=new LinkedList<>();
        Stack<Integer> sub=new Stack<>();
        int answer = 0;

        for(int i=1;i<=order.length;i++)
            main.add(i);
        int num=0;
        while(num<order.length){
            if(main.size()>0){
                if(order[num]>main.peek())
                    sub.push(main.poll());
                else if(order[num]==main.peek()){
                    main.poll();
                    answer++;
                    num++;
                }
                else{
                    if(order[num]==sub.peek()){
                        sub.pop();
                        answer++;
                        num++;
                    }
                    else break;
                }        
            }
            else{
                if(order[num]==sub.peek()){
                        sub.pop();
                        answer++;
                        num++;
                    }
                    else break;
            }
        }
        return answer;
    }
}