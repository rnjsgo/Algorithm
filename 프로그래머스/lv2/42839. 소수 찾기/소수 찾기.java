import java.util.*;
class Solution {
    int answer = 0;
    Map<Integer,Boolean> map=new HashMap<>();
    public int solution(String numbers) {
        boolean[] visited=new boolean[numbers.length()];
        dfs("",visited,0,numbers);
        return answer;
    }
    public void dfs(String number,boolean[] visited,int depth,String numbers){
        if(depth==numbers.length()){
            if(number.length()==0) return;
            int num=Integer.parseInt(number);
            if(!map.containsKey(num)){
                if(isPrime(num)) answer++;
                
                map.put(num,true);
            }
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                String s=number;
                s+=numbers.charAt(i);
                boolean[] visit=visited.clone();
                visit[i]=true;
                dfs(s,visit,depth+1,numbers);
            }
        }
        dfs(number,visited,depth+1,numbers);
    }
    public boolean isPrime(int number){
        if(number<2) return false;
        for(int i=2;i<=Math.sqrt(number);i++)
            if(number%i==0) return false;
        return true;
    }
    
}