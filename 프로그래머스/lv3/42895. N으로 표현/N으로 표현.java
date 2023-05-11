class Solution {
    int answer=Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(0,0,N,number);
        if(answer==Integer.MAX_VALUE) return -1;
        else return answer;
    }
    public void dfs(int count,int value,int N,int number){
        if(count>8) return;
        if(value==number){
            answer=Math.min(answer,count);
            return;
        }
        int newN=0;
        for(int i=0;i<5;i++){
            newN=newN*10+N;
            dfs(count+1+i,value+newN,N,number);
            dfs(count+1+i,value-newN,N,number);
            dfs(count+1+i,value*newN,N,number);
            dfs(count+1+i,value/newN,N,number);
        }
    }
}