import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        Node lever=null;
        Node exit=null;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='S')
                    lever=bfs(i,j,'L',maps);
            }
        }
        if(lever.distance==-1) return -1;
        exit=bfs(lever.r,lever.c,'E',maps);
        if(exit.distance==-1) return -1;
        
        return lever.distance+exit.distance;
    }
    public Node bfs(int r,int c,char destination,String[] maps){
        Queue<Node> queue=new LinkedList<>();
        boolean[][] visited=new boolean[maps.length][maps[0].length()];
        queue.add(new Node(r,c,0));
        visited[r][c]=true;
        
        while(!queue.isEmpty()){
            Node node=queue.poll();
            visited[node.r][node.c]=true;
            
            if(maps[node.r].charAt(node.c)==destination) return node;
        
            if(node.r>0&&!visited[node.r-1][node.c]&&maps[node.r-1].charAt(node.c)!='X'){
                visited[node.r-1][node.c]=true;
                queue.add(new Node(node.r-1,node.c,node.distance+1));
            }
            if(node.r<maps.length-1&&!visited[node.r+1][node.c]&&maps[node.r+1].charAt(node.c)!='X'){
                visited[node.r+1][node.c]=true;
                queue.add(new Node(node.r+1,node.c,node.distance+1));
            }
            if(node.c>0&&!visited[node.r][node.c-1]&&maps[node.r].charAt(node.c-1)!='X'){
                visited[node.r][node.c-1]=true;
                queue.add(new Node(node.r,node.c-1,node.distance+1));
            }
            if(node.c<maps[0].length()-1&&!visited[node.r][node.c+1]&&maps[node.r].charAt(node.c+1)!='X'){
                visited[node.r][node.c+1]=true;
                queue.add(new Node(node.r,node.c+1,node.distance+1));
            }
        }
        return new Node(0,0,-1);
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