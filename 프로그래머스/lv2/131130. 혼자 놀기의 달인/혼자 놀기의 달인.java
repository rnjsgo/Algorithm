import java.util.*;
class Solution {
    static int answer=0;
    public int solution(int[] cards) {
        boolean[] visited=new boolean[cards.length];
        ArrayList<Integer> result=new ArrayList<>();
        dfs(1,visited,result,cards);
        
        return answer;
    }
    static void dfs(int next,boolean[] visited,ArrayList<Integer> result,int[] cards){
        visited[next-1]=true;
        int count=1;
        while(true){
            if(visited[cards[next-1]-1]){
                result.add(count);
                break;
            }
            else{
                visited[cards[next-1]-1]=true;
                next=cards[next-1];
                count++;
            }
        }
        boolean hasNext=false;
        for(int i=0;i<cards.length;i++){
            if(visited[i]) continue;
            else{
                hasNext=true;
                dfs(i+1,visited,result,cards);
                break;
            }
        }
        if(!hasNext){
            Collections.sort(result);
            if(result.size()==1) answer=Math.max(answer,0);
            else answer=Math.max(answer,result.get(result.size()-1)*result.get(result.size()-2));
        }
    }
}