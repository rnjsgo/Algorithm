import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Integer> list=new LinkedList<>();
        for(int n:priorities)
            list.add(n);
        while(true){
            int num=list.poll();
            boolean isPrinted=true;
            for(int i=0;i<list.size();i++){
                if(num<list.get(i)){
                    if(location==0) location=list.size();
                    else location--;
                    list.add(num);
                    isPrinted=false;
                    break;
                }
            }
            if(isPrinted){
                if(location==0) break;
                else answer++;
                location--;
            }
        }
        return answer;
    }
}