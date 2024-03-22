import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Boolean> map = new HashMap();
        
        for(int i = 0 ; i<skip.length() ; i++){
            map.put(skip.charAt(i), true);
        }
        
        for(int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            for(int j = 0 ; j<index; j++){
                c+=1;
                if(c == '{') c = 'a';
                if(map.getOrDefault(c, false)) j--;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}