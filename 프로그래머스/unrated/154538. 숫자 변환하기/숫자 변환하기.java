class Solution {
    static final int MAX=Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer=0;
        int[] dp=new int[y+1];
        for(int i=x+1;i<=y;i++){
            int a=MAX, b=MAX, c=MAX,min;
            if(i-n>=x) a=dp[i-n];
            if(i%2==0&&i/2>=x) b=dp[i/2];
            if(i%3==0&&i/3>=x) c=dp[i/3];
            min=Math.min(a,b);
            min=Math.min(min,c);
            dp[i]=(min!=MAX)?min+1:MAX;
        }
        return (dp[y]==MAX) ? -1:dp[y];
    }
   
}