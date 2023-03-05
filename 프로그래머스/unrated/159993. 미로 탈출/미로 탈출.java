import java.util.*;
class Node{
    int r,c,distance;
    Node(int r,int c, int distance){
        this.r=r;
        this.c=c;
        this.distance=distance;
    }
}
class Solution {
    static Queue<Node> queue=new LinkedList<>();
    static boolean[][] visited;
    static Node findNode;
    public int solution(String[] maps) {
        for(int i=0;i<maps.length;i++){
            boolean isFindStart=false;
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='S'){
                    visited=new boolean[maps.length][maps[0].length()];
                    queue.add(new Node(i,j,0));
                    bfs('L',maps);
                    if(findNode.distance==-1) return -1;
                    isFindStart=true;
                    break;
                }
            }
            if(isFindStart) break;
        }
        visited=new boolean[maps.length][maps[0].length()];
        queue=new LinkedList<>();
        queue.add(findNode);
        bfs('E',maps);
        return findNode.distance;
    }
    public static void bfs(char search,String[] maps){
        while(!queue.isEmpty()){
            Node node=queue.poll();
            visited[node.r][node.c]=true;
            if(maps[node.r].charAt(node.c)==search){
                findNode=node;
                return;
            }
            if(node.r>0&&!visited[node.r-1][node.c]&&maps[node.r-1].charAt(node.c)!='X'){
                queue.add(new Node(node.r-1,node.c,node.distance+1));
                visited[node.r-1][node.c]=true;
            }
            if(node.r<maps.length-1&&!visited[node.r+1][node.c]&&maps[node.r+1].charAt(node.c)!='X'){
                queue.add(new Node(node.r+1,node.c,node.distance+1));
                visited[node.r+1][node.c]=true;
            }
            if(node.c>0&&!visited[node.r][node.c-1]&&maps[node.r].charAt(node.c-1)!='X'){
                queue.add(new Node(node.r,node.c-1,node.distance+1));
                visited[node.r][node.c-1]=true;
            }
            if(node.c<maps[0].length()-1&&!visited[node.r][node.c+1]&&maps[node.r].charAt(node.c+1)!='X'){
                queue.add(new Node(node.r,node.c+1,node.distance+1));
                visited[node.r][node.c+1]=true;
            }
        }
        findNode=new Node(-1,-1,-1);
    }
}