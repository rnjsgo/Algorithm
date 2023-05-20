
class Solution {
    public long solution(int m, int n, int[][] puddles) {
        long[][] road=new long[n][m];
        for(int[] p:puddles)
            road[p[1]-1][p[0]-1]=-1;
        road[0][0]=1;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(road[r][c]==-1) continue;
                if(r>0&&road[r-1][c]!=-1) road[r][c]+=road[r-1][c];
                if(c>0&&road[r][c-1]!=-1) road[r][c]+=road[r][c-1];
                road[r][c]%=1000000007;
            }
        }
        return road[n-1][m-1];
    }
}
