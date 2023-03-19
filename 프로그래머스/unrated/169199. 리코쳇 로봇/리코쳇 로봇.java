import java.util.*;
class Solution {
    int answer=Integer.MAX_VALUE;
    public int solution(String[] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j)=='R')
                    dfs(i,j,i,j,0,board);
            }
        }
        if(answer==Integer.MAX_VALUE) return -1;
        return answer;
    }
    public void dfs(int r,int c,int lastR,int lastC,int count,String[] board){
        if(count>30) return;
        if(board[r].charAt(c)=='G'){
            answer=Math.min(answer,count);
            return;
        }
        
        if(r>0&&board[r-1].charAt(c)!='D'&&r-1!=lastR){
            int newR=r;
            while(newR>0&&board[newR-1].charAt(c)!='D')
                newR--;
            dfs(newR,c,newR+1,c,count+1,board);
        }
        if(r<board.length-1&&board[r+1].charAt(c)!='D'&&r+1!=lastR){
            int newR=r;
            while(newR<board.length-1&&board[newR+1].charAt(c)!='D')
                newR++;
            dfs(newR,c,newR-1,c,count+1,board);
        }
        if(c>0&&board[r].charAt(c-1)!='D'&&c-1!=lastC){
            int newC=c;
            while(newC>0&&board[r].charAt(newC-1)!='D')
                newC--;
            dfs(r,newC,r,newC+1,count+1,board);
        }
        if(c<board[0].length()-1&&board[r].charAt(c+1)!='D'&&c+1!=lastC){
            int newC=c;
            while(newC<board[0].length()-1&&board[r].charAt(newC+1)!='D')
                newC++;
            dfs(r,newC,r,newC-1,count+1,board);
        }
    }
}
