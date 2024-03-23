import java.util.*;

class Solution {
    Map<String,Integer> friendNum = new HashMap<>();
    Friend[] friendList;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        friendList = new Friend[friends.length];
        
        for(int i=0;i<friends.length;i++){
            friendNum.put(friends[i],i);
            friendList[i] = new Friend(friends[i]);
        }
        
        for(String g : gifts){
            Friend give = friendList[friendNum.get(g.split(" ")[0])];
            Friend receive = friendList[friendNum.get(g.split(" ")[1])];
            
            give.updateGive();
            receive.updateReceive();
            give.updateGiveList(receive.getName());
        }
        
        for(String f : friends){
            answer = Math.max(answer, predict(f));
        }
        
        return answer;
    }
    
    public int predict(String f){
        int gift = 0;
        Friend friend = friendList[friendNum.get(f)];
        
        for(Friend compare : friendList){
            if(friend.getName().equals(compare.getName())) continue;
            int friendGive = friend.getGiveCount(compare);
            int compareGive = compare.getGiveCount(friend);
            
            if(friendGive > compareGive) gift++;
            else if(friendGive == compareGive){
                if(friend.getGiftscore() > compare.getGiftscore()) gift++;
            }
        }
        return gift;
    }
}

class Friend {
    private String name;
    private int give;
    private int receive;
    private Map<String, Integer> giveList;
    
    public Friend(String name){
        this.name = name;
        this.give = 0;
        this.receive = 0;
        this.giveList = new HashMap<>();
    }
    
    public int getGiftscore(){
        return give - receive;
    }
    
    public void updateGive(){
        give+=1;
    }
    
    public void updateReceive(){
        receive+=1;
    }
    
    public void updateGiveList(String receive){
        int count = giveList.getOrDefault(receive,0);
        giveList.put(receive,count+1);
    }
    
    public int getGiveCount(Friend friend){
        return giveList.getOrDefault(friend.getName(), 0);
    }
    
    public String getName(){
        return name;
    }
}