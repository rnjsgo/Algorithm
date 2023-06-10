import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Integer,Integer> map=new HashMap();
        List<Integer> tupleList=new ArrayList<>();
        
        s=s.substring(2,s.length()-2);
        String[] list=s.split("\\},\\{");
        Arrays.sort(list,(a,b)->a.length()-b.length());
        
        for(String str:list){
            for(String num:str.split(",")){
                int n=Integer.parseInt(num);
                if(map.containsKey(n)){
                    continue;
                }
                else{
                    map.put(n,1);
                    tupleList.add(n);
                    break;
                }
            }
        }
        
        int[] answer=new int[tupleList.size()];
        for(int i=0;i<tupleList.size();i++){
            answer[i]=tupleList.get(i);
        }
        
        return answer;
    }
}