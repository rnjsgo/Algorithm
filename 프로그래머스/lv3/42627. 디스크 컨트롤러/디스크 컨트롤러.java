import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> list=new ArrayList<>();
        for(int[] arr:jobs)
            list.add(arr);
        Collections.sort(list,(a,b)->a[1]-b[1]);
        int size=list.size();
        int time=0;
        while(!list.isEmpty()){
            boolean isSuccess=false;
            for(int i=0;i<list.size();i++){
                if(list.get(i)[0]<=time){
                    time+=list.get(i)[1];
                    answer+=time-list.get(i)[0];
                    list.remove(i);
                    isSuccess=true;
                    break;
                }
            }
            if(!isSuccess){
                int min=list.get(0)[0];
                int index=0;
                for(int i=1;i<list.size();i++){
                    if(min>list.get(i)[0]){
                        min=list.get(i)[0];
                        index=i;
                    }
                }
                time=list.get(index)[0]+list.get(index)[1];
                answer+=list.get(index)[1];
                list.remove(index);
            }
        }
        return answer/size;
    }
}