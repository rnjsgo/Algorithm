class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr=new int[n][m];
        for(int i=0;i<puddles.length;i++)
            arr[puddles[i][1]-1][puddles[i][0]-1]=-1;
        arr[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==-1) continue;
                if(i>0&&arr[i-1][j]!=-1) arr[i][j]=(arr[i][j]+arr[i-1][j])%1000000007;
                if(j>0&&arr[i][j-1]!=-1) arr[i][j]=(arr[i][j]+arr[i][j-1])%1000000007;
            }
        }
        return arr[n-1][m-1];
    }
}