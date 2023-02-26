class Solution {
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        for(int i=0;i<dungeons.length;i++){
            boolean[] visited=new boolean[dungeons.length];
            dfs(i,k,0,visited,dungeons);
        }
        return answer;
    }
    public void dfs(int start, int hp, int count, boolean[] visited, int[][] dungeons){
        visited=visited.clone();
        if(hp>=dungeons[start][0]&&visited[start]!=true){
            visited[start]=true;
            hp-=dungeons[start][1];
            count++;
            for(int i=0;i<visited.length;i++){
                if(visited[i%visited.length]==false)
                    dfs(i,hp,count,visited,dungeons);
            }
        }
        answer=Math.max(answer,count);
    }
}