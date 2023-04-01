import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String[]> working=new Stack<>();
        Queue<String[]> wait=new LinkedList<>();
        int index=0;
        
        Arrays.sort(plans,(a,b)->{
            if(a[1].split(":")[0].equals(b[1].split(":")[0]))
                return Integer.parseInt(a[1].split(":")[1])-Integer.parseInt(b[1].split(":")[1]);
            
            else 
                return Integer.parseInt(a[1].split(":")[0])-Integer.parseInt(b[1].split(":")[0]);
        });
        
        for(String[] s:plans)
            wait.add(s);
        
        while(!wait.isEmpty()){
            working.push(wait.poll());
            if(wait.isEmpty()){
                while(!working.isEmpty()){
                    answer[index]=working.pop()[0];
                    index++;
                }
                break;
            }
            int term=calcTerm(wait.peek()[1],working.peek()[1]);
            while(!working.isEmpty()&&term>0){
                if(term>=Integer.parseInt(working.peek()[2])){
                    answer[index]=working.peek()[0];
                    term-=Integer.parseInt(working.pop()[2]);
                    index++;
                }
                else{
                    String[] work= working.pop();
                    work[2]=String.valueOf((Integer.parseInt(work[2])-term));
                    working.push(work);
                    term=0;
                }
            }
        }
        return answer;
    }
    public int calcTerm(String wait, String working){
        int waitMin=Integer.parseInt(wait.split(":")[0])*60+Integer.parseInt(wait.split(":")[1]);
        int workMin=Integer.parseInt(working.split(":")[0])*60+Integer.parseInt(working.split(":")[1]);
        return waitMin-workMin;
    }
}