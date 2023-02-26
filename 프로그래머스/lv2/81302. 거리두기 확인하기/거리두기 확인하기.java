class Solution {
    int[] answer = {1,1,1,1,1};
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    boolean[][] visited;
    public int[] solution(String[][] places) {
        for(int i=0;i<5;i++){
            visited=new boolean[5][5];
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(places[i][j].charAt(k)=='P')
                        dfs(i,j,k,j,k,places[i]);
                }
            }
        }
        return answer;
    }
    public void dfs(int num,int r,int c, int nr,int nc,String[] arr){
        visited[nr][nc]=true;
        for(int i=0;i<4;i++){
            int newR=nr+dr[i];
            int newC=nc+dc[i];
            if(newR<0||newC<0||newR>4||newC>4||visited[newR][newC]==true)
                continue;
            if(Math.abs(r-newR)+Math.abs(c-newC)>2)
                continue;
            if(arr[newR].charAt(newC)=='P'){
                answer[num]=0;
                return;
            }
            else if(arr[newR].charAt(newC)=='O')
                dfs(num,r,c,newR,newC,arr);
            else visited[newR][newC]=true;
        }
        
    }
}