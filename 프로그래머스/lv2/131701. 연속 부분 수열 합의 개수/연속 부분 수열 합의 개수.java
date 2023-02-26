import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] calc=new int[elements.length];
        Set<Integer> answer=new HashSet<>();
        for(int i=0;i<elements.length-1;i++){
            for(int j=0;j<elements.length;j++){
                if(i+j>=elements.length)
                    calc[j]+=elements[i+j-elements.length];
                else
                    calc[j]+=elements[i+j];
            }
            
            for(int j=0;j<elements.length;j++)
                answer.add(calc[j]);        
        }
        return answer.size()+1;
    }
}