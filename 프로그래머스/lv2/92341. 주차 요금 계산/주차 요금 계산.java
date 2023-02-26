import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,String> parking=new HashMap<>();
        Map<String,Integer> result=new HashMap<>();
        for(String s:records){
            String[] record=s.split(" ");
            if(record[2].equals("IN"))
                parking.put(record[1],record[0]);
            else{
                if(result.containsKey(record[1]))
                    result.put(record[1],result.get(record[1])+calcTime(parking.get(record[1]),record[0]));
                else
                    result.put(record[1],calcTime(parking.get(record[1]),record[0]));
                parking.remove(record[1]);
            }    
        }
        for(String s:parking.keySet()){
            if(result.containsKey(s))
                result.put(s,result.get(s)+calcTime(parking.get(s),"23:59"));
            else    
                result.put(s,calcTime(parking.get(s),"23:59"));
        }

        ArrayList<String> sortedNum= new ArrayList<>(result.keySet());
        Collections.sort(sortedNum);
        int[] answer=new int[result.size()];
        for(int i=0; i<sortedNum.size();i++)
            answer[i]=calcFee(result.get(sortedNum.get(i)),fees);
        
        return answer;
    }                    
    
    public int calcTime(String in,String out){
        int start=60*Integer.parseInt(in.split(":")[0])+Integer.parseInt(in.split(":")[1]);
        int end=60*Integer.parseInt(out.split(":")[0])+Integer.parseInt(out.split(":")[1]);
        return end-start;
    }
   
   public int calcFee(int time,int[] fees){
       int fee=0;
       time-=fees[0];
       fee+=fees[1];
       
       if(time>0){
           if(time%fees[2]==0) fee+=fees[3]*(time/fees[2]);
           else fee+=fees[3]*(time/fees[2]+1);
       }
       return fee;
   }
                           
}