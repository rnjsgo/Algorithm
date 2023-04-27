class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=columns*i+j+1;
            }
        }
        for(int i=0;i<answer.length;i++){
            int min=Integer.MAX_VALUE;
            int[][] arrSample=new int[rows][columns];
            for(int j=0;j<arr.length;j++)
                arrSample[j]=arr[j].clone();
            
            for(int r=queries[i][0]-1;r<queries[i][2];r++){
                for(int c=queries[i][1]-1;c<queries[i][3];c++){
                    if(r==queries[i][0]-1){
                        if(c==queries[i][1]-1) arr[r][c]=arrSample[r+1][c];
                        else arr[r][c]=arrSample[r][c-1];
                    }
                    else if(r==queries[i][2]-1){
                        if(c==queries[i][3]-1) arr[r][c]=arrSample[r-1][c];
                        else arr[r][c]=arrSample[r][c+1];
                    }
                    else{
                        if(c==queries[i][1]-1) arr[r][c]=arrSample[r+1][c];
                        else if(c==queries[i][3]-1) arr[r][c]=arrSample[r-1][c];
                        else continue;
                    }
                    min=Math.min(min,arrSample[r][c]);
                }
            }
            answer[i]=min;
        }
        return answer;
    }
}