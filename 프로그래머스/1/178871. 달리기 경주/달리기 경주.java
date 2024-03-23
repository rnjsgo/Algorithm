import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String,Integer> player = new HashMap();
        Map<Integer,String> rank = new HashMap();
        
        for(int i=1; i<=players.length;i++){
            player.put(players[i-1],i);
            rank.put(i,players[i-1]);
        }
        
        for(String c : callings){
            int beforeRank = player.get(c);
            player.put(c,beforeRank-1);
            
            String slowPlayer = rank.get(beforeRank-1);
            player.put(slowPlayer,beforeRank);
            
            rank.put(beforeRank-1,c);
            rank.put(beforeRank,slowPlayer);
        }
        
        for(int i=1;i<=players.length;i++){
            answer[i-1] = rank.get(i);
        }
        return answer;
    }
}