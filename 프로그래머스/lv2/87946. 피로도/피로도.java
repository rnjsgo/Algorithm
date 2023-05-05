class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length;i++){
            if(k<dungeons[i][0]) continue;
            boolean[] visited=new boolean[dungeons.length];
            dfs(k-dungeons[i][1],i,1,visited,dungeons);
        }
        return answer;
    }
    public void dfs(int hp,int position, int count,boolean[] visited,int[][] dungeons){
        visited[position]=true;
        answer=Math.max(answer,count);
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]&&hp>=dungeons[i][0]){
                dfs(hp-dungeons[i][1],i,count+1,visited.clone(),dungeons);
            }
        }
    }
}