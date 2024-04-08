import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Node> map = new HashMap<>();
        
        for(int[] edge : edges){
            int in = edge[1];
            int out = edge[0];
            
            if(map.containsKey(in)){
                Node node = map.get(in);
                node.updateIn();
            }
            else{
                Node node = new Node();
                node.updateIn();
                map.put(in, node);
            }
            if(map.containsKey(out)){
                Node node = map.get(out);
                node.updateOut();
            }
            else{
                Node node = new Node();
                node.updateOut();
                map.put(out, node);
            }
        }
        
        for(int key : map.keySet()){
            Node node = map.get(key);
            int in = node.getIn();
            int out = node.getOut();
            
            if(out == 0){
                answer[2]++;
            }
            else if(out >= 2){
                if(in == 0) answer[0] = key;
                else answer[3] ++;
            }
        }
        
        Node node = map.get(answer[0]);
        answer[1] = node.getOut() - answer[2] - answer[3];
        
        return answer;
    }
}

class Node {
    int in;
    int out;
    
    public Node(){
        this.in = 0;
        this.out = 0;
    }
    
    public void updateIn(){
        in+=1;
    }
    
    public void updateOut(){
        out+=1;
    }
    
    public int getIn(){
        return in;
    }
    
    public int getOut(){
        return out;
    }
}