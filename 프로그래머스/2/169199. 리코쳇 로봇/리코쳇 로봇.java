import java.util.*; 

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    public int solution(String[] board) {
        int answer = 0;
        n = board.length; 
        m = board[0].length();
        
        int[] robotPosition= findRobot(board, 'R');
        answer = bfs(robotPosition, 'G', board);
        return (answer == 0)? -1 : answer;
    }
    
    public int[] findRobot(String[] board, char destination){
        int[] find= new int[2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j) == destination){
                    find[0] = i;
                    find[1] = j;
                    return find;
                }
            }
        }
        return find;
    }
    
    public int bfs(int[] start, char destination, String[] board){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0));
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int r = now.getRow();
            int c = now.getColumn();
            int distance = now.getDistance();
            
            if(board[r].charAt(c) == destination) return distance;
            
            for(int i=0; i<4; i++){
                int nextR = r;
                int nextC = c;
                
                for(int j=0; j<Math.max(n,m); j++){
                    nextR += dx[i];
                    nextC += dy[i];
                    
                    if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || board[nextR].charAt(nextC) == 'D'){
                        nextR -= dx[i];
                        nextC -= dy[i];
                        break;
                    }
                }
                if(!visited[nextR][nextC]){
                    queue.add(new Node(nextR, nextC, distance+1));
                    visited[nextR][nextC] = true;
                }
            }
        }
        return 0;
    }
}

class Node{
    int r, c, distance;
    
    public Node(int r, int c, int distance){
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
    
    public int getRow(){
        return r;
    }
    
    public int getColumn(){
        return c;
    }
    
    public int getDistance(){
        return distance;
    }
}