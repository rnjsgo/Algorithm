import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int[] startPosition = findDestination(maps, 'S');
        queue.add(new Node(startPosition[0], startPosition[1], 0));
        visited[startPosition[0]][startPosition[1]] = true;
        int distance = bfs(queue, 'L', visited, maps);
        if(distance == 0) return -1;
        else answer += distance;
        
        visited = new boolean[maps.length][maps[0].length()];
        int[] leverPosition = findDestination(maps, 'L');
        queue.add(new Node(leverPosition[0], leverPosition[1], 0));
        visited[leverPosition[0]][leverPosition[1]] = true;
        distance = bfs(queue, 'E', visited, maps);
        if(distance == 0) return -1;
        else answer += distance;
        
        return answer;
    }
    public int[] findDestination(String maps[], char destination){
        int[] find = new int[2];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == destination){
                    find[0] = i;
                    find[1] = j;
                    return find;
                }
            }
        }
        return find;
    }
    public int bfs(Queue<Node> queue, char destination, boolean[][] visited, String[] maps){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int r = node.getRow();
            int c = node.getColumn();
            
            if(maps[r].charAt(c) == destination){
                queue.clear();
                return node.distance;
            }
            
            
            if(r > 0 && !visited[r-1][c] && maps[r-1].charAt(c) != 'X'){
                queue.add(new Node(r-1, c, node.distance + 1));
                visited[r-1][c] = true;
            }
            if(r < maps.length - 1 && !visited[r+1][c] && maps[r+1].charAt(c) != 'X'){
                queue.add(new Node(r+1, c, node.distance + 1));
                visited[r+1][c] = true;
            }
            if(c > 0 && !visited[r][c-1] && maps[r].charAt(c-1) != 'X'){
                visited[r][c-1] = true;
                queue.add(new Node(r, c-1, node.distance + 1));
            }
            if(c < maps[0].length() -1  && !visited[r][c+1] && maps[r].charAt(c+1) != 'X'){
                visited[r][c+1] = true;
                queue.add(new Node(r, c+1, node.distance + 1));
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
}