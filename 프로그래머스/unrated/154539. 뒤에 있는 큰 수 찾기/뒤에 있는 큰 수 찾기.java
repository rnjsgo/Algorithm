import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> index=new Stack<>();
        for(int i=0;i<numbers.length;i++){
            if(index.isEmpty())
                index.push(i);
            else{
                if(numbers[index.peek()]>=numbers[i])
                    index.push(i);
                else{
                    while(!index.isEmpty()&&numbers[index.peek()]<numbers[i]){
                        answer[index.pop()]=numbers[i];
                    }
                    index.push(i);
                }  
            }
        }
        for(int i:index)
            answer[i]=-1;
        return answer;
    }
}