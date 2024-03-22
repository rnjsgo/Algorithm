import java.util.*;

class Solution {
    int todayYear;
    int todayMonth;
    int todayDay;
    List<Integer> list = new ArrayList();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] date = today.split("\\.");
        this.todayYear = Integer.parseInt(date[0]);
        this.todayMonth = Integer.parseInt(date[1]);
        this.todayDay = Integer.parseInt(date[2]);
        
        for(int i=1; i<=privacies.length; i++){
            String[] privacy = privacies[i-1].split(" ");
            for(String t : terms){
                String[] term = t.split(" ");
                if(privacy[1].equals(term[0])){
                    check(privacy[0], Integer.parseInt(term[1]), i);
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void check(String startDate, int term, int index){
        String[] date = startDate.split("\\.");
        int startYear = Integer.parseInt(date[0]);
        int startMonth = Integer.parseInt(date[1]);
        int startDay = Integer.parseInt(date[2]);
        
        startMonth += term;
        if(startMonth > 12){
            startYear += startMonth/12;
            startMonth = startMonth%12;
            if(startMonth == 0){
                startYear-= 1 ;
                startMonth = 12;
            }
        }
        
        if(todayYear > startYear){
            list.add(index);
        } else if(todayYear == startYear){
            if(todayMonth > startMonth){
                list.add(index);
            } else if(todayMonth == startMonth){
                if(todayDay >= startDay){
                    list.add(index);
                }
            }
        }
    }
}