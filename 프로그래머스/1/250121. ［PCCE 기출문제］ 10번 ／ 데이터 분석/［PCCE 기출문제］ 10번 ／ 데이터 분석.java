import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> sortedList = new ArrayList();
        
        Map<String,Integer> dataIndex = new HashMap();
        dataIndex.put("code",0);
        dataIndex.put("date",1);
        dataIndex.put("maximum",2);
        dataIndex.put("remain",3);
        int index = dataIndex.get(ext);
        int sortIndex = dataIndex.get(sort_by);
        
        for(int[] d : data){
            if(d[index]<val_ext) sortedList.add(d);
        }
        Collections.sort(sortedList,(a,b)->
                         a[sortIndex]-b[sortIndex]);
        
        int[][] answer = new int[sortedList.size()][];
        for(int i=0;i<sortedList.size();i++){
            answer[i]=sortedList.get(i);
        }
        
        return answer;
    }
}