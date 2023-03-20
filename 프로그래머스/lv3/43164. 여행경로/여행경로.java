import java.util.*;
class Solution {
    List<List<String>> result=new ArrayList<>();
    public String[] solution(String[][] tickets) {
        List<String[]> ticket=new ArrayList<>();
        List<String> route=new ArrayList<>();
        for(String[] s:tickets)
            ticket.add(s);
        dfs("ICN",route,ticket);
        Collections.sort(result,(a,b)->{
            for(int i=1;i<a.size();i++){
                for(int j=0;j<3;j++){
                if(a.get(i).charAt(j)!=b.get(i).charAt(j))
                    return a.get(i).charAt(j)-b.get(i).charAt(j);
                }
            }
            for(int i=0;i<3;i++){
                if(a.get(1).charAt(i)!=b.get(1).charAt(i))
                    return a.get(1).charAt(i)-b.get(1).charAt(i);
            }
            return a.get(1).charAt(0)-b.get(1).charAt(0);
        });
        String[] answer=new String[result.get(0).size()];
        for(int i=0;i<result.get(0).size();i++){
            answer[i]=result.get(0).get(i);
        }
        return answer;
    }
    public void dfs(String here,List<String> route,List<String[]> ticket){
        route.add(here);
        for(int i=0;i<ticket.size();i++){
            if(ticket.get(i)[0].equals(here)){
                List<String> newRoute=new ArrayList<>(route);
                List<String[]> newTicket=new ArrayList<>(ticket);
                newTicket.remove(i);
                if(newTicket.size()==0){
                    newRoute.add(ticket.get(i)[1]);
                    result.add(newRoute);
                    break;
                }
                dfs(ticket.get(i)[1],newRoute,newTicket);
            }
        }
    }
}