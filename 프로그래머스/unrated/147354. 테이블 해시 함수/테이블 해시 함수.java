import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(a,b)->{
                    if(a[col-1]==b[col-1]) return b[0]-a[0];
                    else return a[col-1]-b[col-1];
        });
        
        String result=makeS_i(row_begin,data);   
        
        for(int i=row_begin+1;i<=row_end;i++){
            String compare=makeS_i(i,data);
            result=bitwiseXOR(result,compare);
        }
        return Integer.parseInt(result,2);
    }
    public String makeS_i(int row_begin,int[][] data){
        int sum=0;
        for(int i=0;i<data[0].length;i++)
            sum+=data[row_begin-1][i]%row_begin;
        return Integer.toString(sum,2);
    }
    
    public String bitwiseXOR(String a, String b){
        StringBuilder A,B;
        int sizeDiff=a.length()-b.length();
        if(sizeDiff>=0){
            A=new StringBuilder(a);
            B=new StringBuilder(b);
        }
        else{
            A=new StringBuilder(b);
            B=new StringBuilder(a);
        }
        
        for(int i=0;i<Math.abs(sizeDiff);i++)
                B.insert(0,"0");

        StringBuilder result=new StringBuilder();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==B.charAt(i)) result.append("0");
            else result.append("1");
        }
        
        return result.toString();
    }
}