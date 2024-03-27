import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Queue<Task> task = new LinkedList<>();
        Stack<Task> remain = new Stack<>();
        List<String> end = new ArrayList<>();
        
        sortByStart(plans);
        
        for(String[] plan : plans){
            task.add(new Task(plan));
        }
        
        while(!task.isEmpty() || !remain.isEmpty()){
            Task thisTask = task.poll();
            String taskName = thisTask.getName();
            int convertedStart = convertTime(thisTask.getStart());
            int playtime = thisTask.getPlaytime();
                
            if(task.isEmpty()){
                end.add(taskName);
                while(!remain.isEmpty()) end.add(remain.pop().getName());
            }
            else{
                int endTime = convertedStart + playtime;
                int nextTaskTime = convertTime(task.peek().getStart());
                if(endTime > nextTaskTime){
                    thisTask.setPlaytime(endTime - nextTaskTime);              
                    remain.push(thisTask);
                }
                else{
                    end.add(taskName);
                    int remainTime = nextTaskTime - endTime;
                    while(remainTime > 0 && !remain.isEmpty()){
                        Task remainTask = remain.pop();
                        int remainPlaytime = remainTask.getPlaytime();
                        if(remainTime >= remainPlaytime){
                            remainTime -= remainPlaytime;
                            end.add(remainTask.getName());
                        }
                        else{
                            remainTask.setPlaytime(remainPlaytime - remainTime);
                            remain.push(remainTask);
                            break;
                        }
                    }
                }
            }
            
        }
        
        for(int i=0; i<end.size(); i++)
            answer[i] = end.get(i);
        
        return answer;
    }
    
    public void sortByStart(String[][] plans){
        Arrays.sort(plans, (a,b)->{
            String startA = a[1];
            String startB = b[1];
            
            int hourA = Integer.parseInt(startA.split(":")[0]);
            int minuteA = Integer.parseInt(startA.split(":")[1]);
            int hourB = Integer.parseInt(startB.split(":")[0]);
            int minuteB = Integer.parseInt(startB.split(":")[1]);
            
            if(hourA == hourB) return minuteA - minuteB;
            else return hourA - hourB;
        });
    }
    
    public int convertTime(String start){
        int hour = Integer.parseInt(start.split(":")[0]);
        int minute = Integer.parseInt(start.split(":")[1]);
        
        return (hour * 60) + minute;
    }
}

class Task{
    String name;
    String start;
    int playtime;
    
    public Task(String[] task){
        this.name = task[0];
        this.start = task[1];
        this.playtime = Integer.parseInt(task[2]);
    }
    
    public String getName(){
        return name;
    }
    
    public String getStart(){
        return start;
    }
    
    public int getPlaytime(){
        return playtime;
    }
    
    public void setPlaytime(int playtime){
        this.playtime = playtime;
    }
}