import java.util.*;
class Solution {
    int answer = -1;
    public int solution(int[][] maps) {
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(0,0,1));
        bfs(0,queue,visited,maps);
        return answer;
    }
    public void bfs(int count,Queue<Node> queue,boolean[][] visited,int[][]maps){
        while(!queue.isEmpty()){
            Node node=queue.poll();
            int r=node.r;
            int c=node.c;
            if(r==maps.length-1&&c==maps[0].length-1){
                answer=node.distance;
                break;
            }
            visited[r][c]=true;
            if(r>0&&maps[r-1][c]==1&&!visited[r-1][c]){
                queue.add(new Node(r-1,c,node.distance+1));
                visited[r-1][c]=true;
            }
            if(r<maps.length-1&&maps[r+1][c]==1&&!visited[r+1][c]){
                queue.add(new Node(r+1,c,node.distance+1));
                visited[r+1][c]=true;
            }
            if(c>0&&maps[r][c-1]==1&&!visited[r][c-1]){
                queue.add(new Node(r,c-1,node.distance+1));
                visited[r][c-1]=true;
            }
            if(c<maps[0].length-1&&maps[r][c+1]==1&&!visited[r][c+1]){
                queue.add(new Node(r,c+1,node.distance+1));
                visited[r][c+1]=true;
            }
        }
    }
}
class Node{
    int r;
    int c;
    int distance;
    Node(int r,int c,int distance){
        this.r=r;
        this.c=c;
        this.distance=distance;
    }
}