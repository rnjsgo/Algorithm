import java.util.*;
class Solution {
    static int count;
    ArrayList<Integer> arr=new ArrayList<>(); 
    public int[] solution(String[] maps) {
        boolean[][] visited=new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                count=0;
                if(!visited[i][j]&&maps[i].charAt(j)!='X'){
                    dfs(i,j,visited,maps);
                    arr.add(count);
                }
            }   
        }
        if(arr.isEmpty()){
            int[] answer={-1};
            return answer;
        }
        int[] answer=new int[arr.size()];
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++)
            answer[i]=arr.get(i);
        
        return answer;
    }
    public static void dfs(int r,int c,boolean[][] visited,String[] maps){
        visited[r][c]=true;
        count+=Character.getNumericValue(maps[r].charAt(c));
        if(r>0&&maps[r-1].charAt(c)!='X'&&!visited[r-1][c])
            dfs(r-1,c,visited,maps);
        if(r<maps.length-1&&maps[r+1].charAt(c)!='X'&&!visited[r+1][c])
            dfs(r+1,c,visited,maps);
        if(c>0&&maps[r].charAt(c-1)!='X'&&!visited[r][c-1])
            dfs(r,c-1,visited,maps);
        if(c<maps[0].length()-1&&maps[r].charAt(c+1)!='X'&&!visited[r][c+1])
            dfs(r,c+1,visited,maps);
    }
}