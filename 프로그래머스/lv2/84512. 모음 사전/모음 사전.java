import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] arr={780,155,30,5,0};
        Map<Character,Integer> map=new HashMap<>();
        map.put('A',0);
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);
        for(int i=0;i<word.length();i++)
            answer+=arr[i]*map.get(word.charAt(i))+map.get(word.charAt(i))+1;
        
        return answer;
    }
}