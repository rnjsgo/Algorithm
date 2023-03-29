import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            list.add(num);
            while(i<arr.length-1&&arr[i+1]==num)
                i++;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i]=list.get(i);
    
        return answer;
    }
}