import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        for(String id : id_list){
            reportMap.put(id, new HashSet<String>());
        }
        
        for(String r : report){
            String reportFrom = r.split(" ")[0];
            String reportTo = r.split(" ")[1];
            HashSet<String> reportFromSet = reportMap.get(reportTo);
            reportFromSet.add(reportFrom);
        }
        
        for(String id : id_list){
            HashSet<String> reportFromSet = reportMap.get(id);
            if(reportFromSet.size() >= k){
                for(String reportFrom : reportFromSet){
                    resultMap.put(reportFrom, resultMap.getOrDefault(reportFrom, 0) + 1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = resultMap.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}