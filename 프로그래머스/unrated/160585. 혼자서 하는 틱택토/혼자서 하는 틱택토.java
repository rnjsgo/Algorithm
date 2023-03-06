class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int countO=0;
        int countX=0;
        int countBingoO=0;
        int countBingoX=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if( board[i].charAt(j)=='O') countO++;
                if( board[i].charAt(j)=='X') countX++;
            }
        }
        if(countX>countO||Math.abs(countX-countO)>1) return 0;
        
        for(int i=0;i<3;i++){
            if(board[i].charAt(0)!='.'){
                char check=board[i].charAt(0);
                if(board[i].charAt(1)==check){
                    if(board[i].charAt(2)==check){
                        if(check=='O') countBingoO++;
                        else countBingoX++;
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            if(board[0].charAt(i)!='.'){
                char check=board[0].charAt(i);
                if(board[1].charAt(i)==check){
                    if(board[2].charAt(i)==check){
                        if(check=='O') countBingoO++;
                        else countBingoX++;
                    }
                }
            }
        }
        
        if(board[0].charAt(0)!='.'){
            char check=board[0].charAt(0);
            if(board[1].charAt(1)==check){
                if(board[2].charAt(2)==check){
                    if(check=='O') countBingoO++;
                    else countBingoX++;
                }
            }
        }
        
        if(board[2].charAt(0)!='.'){
            char check=board[2].charAt(0);
            if(board[1].charAt(1)==check){
                if(board[0].charAt(2)==check){
                    if(check=='O') countBingoO++;
                    else countBingoX++;
                }
            }
        }
        
        if(countBingoO+countBingoX>1){
            if(countBingoO==2&&countBingoX==0&&countO==countX+1)
                return 1;
            else return 0;
        }
        if(countBingoX==1&&countO==countX+1) return 0;
        if(countBingoO==1&&countO==countX) return 0;
        return answer;
    }
}