import java.util.*;
class Solution {
    int Rsize,Csize,Rgoal,Cgoal,count;
    boolean find=false;
    String answer="impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Rsize=n;
        Csize=m;
        Rgoal=r-1;
        Cgoal=c-1;
        count=k;
        dfs(x-1,y-1,"");
        return answer;
    }
    public void dfs(int r,int c,String str){
        if(find) return;
        int distance=Math.abs(r-Rgoal)+Math.abs(c-Cgoal);
        if(distance>count-str.length()||(count-str.length()-distance)%2!=0) return;
        if(str.length()==count){
            find=true;
            if(r==Rgoal&&c==Cgoal) answer=str;
            return;
        }

        if(r<Rsize-1){
            String newStr=str+"d";
            dfs(r+1,c,newStr);
        }
        if(c>0){
            String newStr=str+"l";
            dfs(r,c-1,newStr);
        }
        if(c<Csize-1){
            String newStr=str+"r";
            dfs(r,c+1,newStr);
        }
        if(r>0){
            String newStr=str+"u";
            dfs(r-1,c,newStr);
        }
    }
}