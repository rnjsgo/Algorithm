class Solution {
    static int difference=0;
    static int[] answer=new int[11];
    static int[] apeachResult;
    
    public int[] solution(int n, int[] info) {
        apeachResult=info;
        int[] target=new int[11];
        dfs(target,n,0);
        
        
        if(difference==0){
            int arr[]={-1};
            return arr;
        }
        return answer;
    }
    public static void dfs(int[] target,int leftArrow,int index){
        if(leftArrow==0){
            int lion=0;
            int apeach=0;
            for(int i=0;i<11;i++){
                if(target[i]==0&&apeachResult[i]==0) continue;
                if(target[i]>apeachResult[i]) lion+=10-i;
                else apeach+=10-i;
            }
            if(difference<lion-apeach){
                difference=lion-apeach;
                answer=target;
                return;
            }
            else if(difference==lion-apeach){
                for(int i=10;i>=0;i--){
                    if(target[i]>answer[i]){
                        answer=target;
                        return;
                    }
                    else if(target[i]<answer[i]) return;
                    else continue;
                }
            }
            else return;
        }
        if(index==10){
            target[10]+=leftArrow;
            dfs(target,0,index);
        }
        else{
            int[] winTarget=target.clone();
            int[] loseTarget=target.clone();
            winTarget[index]=apeachResult[index]+1;
            if(leftArrow-winTarget[index]>=0)
                dfs(winTarget,leftArrow-winTarget[index],index+1);
            dfs(loseTarget,leftArrow,index+1);
        }
    }
}