import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList();
        
        for(int[] road:roads){
            int start=road[0];
            int end=road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        int[] distance=bfs(n,graph,destination);
        for(int i=0;i<answer.length;i++){
            if(distance[sources[i]]==0){
                if(sources[i]==destination) answer[i]=0;
                else answer[i]=-1;
            }
            else answer[i]=distance[sources[i]];
        }
        return answer;
    }
    public int[] bfs(int n, ArrayList<Integer>[] graph, int destination){
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(destination,0));
        int[] distanceList=new int[n+1];
        boolean[] visited=new boolean[n+1];
        
        while(!queue.isEmpty()){
            Node start=queue.poll();
            visited[start.position]=true;
            for(int node:graph[start.position]){
                if(!visited[node]){
                    distanceList[node]=start.distance+1;
                    queue.add(new Node(node,start.distance+1));
                    visited[node]=true;
                }
            }
        }
        return distanceList;
    }
}
class Node{
    int position;
    int distance;
    Node(int position, int distance){
        this.position=position;
        this.distance=distance;
    }
}