import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] distanceList = new int[n+1];
        
        for(int i=1;i<=n;i++)
            list[i]=new ArrayList();
        
        for(int[] road : roads){
            int pos1 = road[0];
            int pos2 = road[1];
            list[pos1].add(pos2);
            list[pos2].add(pos1);
        }
        
        bfs(destination, list, distanceList);
        
        for(int i=0; i<sources.length; i++){
            if(distanceList[sources[i]] == 0 && sources[i] != destination)
                answer[i] = -1;
            else answer[i] = distanceList[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int destination, ArrayList[] list, int[] distanceList){
        int count = 0;
        boolean[] visited = new boolean[list.length];
        visited[destination] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(destination, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int now = node.getPosition();
            ArrayList<Integer> linkedList = list[now];
            
            for(int pos : linkedList){
                if(!visited[pos]){
                    visited[pos] = true;
                    distanceList[pos] = node.getDistance() + 1;
                    queue.add(new Node(pos, node.getDistance() + 1));
                }
            }
        }
    }
}

class Node{
    private int position;
    private int distance;
    
    public Node(int position, int distance){
        this.position = position;
        this.distance = distance;
    }
    
    public int getPosition(){
        return position;
    }
    
    public int getDistance(){
        return distance;
    }
}