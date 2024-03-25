import java.util.*;

class Solution {
    int sum;
    List<Integer> resultArr = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    sum = 0;
                    dfs(i, j, visited, maps);
                    resultArr.add(sum);
                }
            }
        }
        if(resultArr.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        Collections.sort(resultArr);
        
        return resultArr.stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    public void dfs(int r, int c, boolean[][] visited, String[] maps){
        sum += Character.getNumericValue(maps[r].charAt(c));
        visited[r][c] = true;
        
        if(r > 0 && !visited[r-1][c] && maps[r-1].charAt(c) != 'X') 
            dfs(r-1, c, visited, maps);
        if(r < maps.length - 1 && !visited[r+1][c]&& maps[r+1].charAt(c) != 'X') 
            dfs(r+1, c, visited, maps);
        if(c > 0 && !visited[r][c-1] && maps[r].charAt(c-1) != 'X')
            dfs(r, c-1, visited, maps);    
        if(c < maps[0].length() - 1 && !visited[r][c+1] && maps[r].charAt(c+1) != 'X')
            dfs(r, c+1, visited, maps);   
    }
}