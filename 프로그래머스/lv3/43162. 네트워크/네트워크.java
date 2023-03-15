class Solution {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int num,boolean[] visited,int[][] computers){
        visited[num]=true;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]&&computers[num][i]==1){
                dfs(i,visited,computers);
            }
        }
    }
}