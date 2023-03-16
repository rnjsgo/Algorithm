class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited=new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                dfs(begin,target,0,visited,words);
                break;
            }
        }
        if(answer==Integer.MAX_VALUE) return 0;
        return answer;
    }
    public void dfs(String word, String target,int count,boolean[] visited,String[] words){
        if(word.equals(target)){
            answer=Math.min(answer,count);
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;
            int difference=0;
            for(int j=0;j<target.length();j++){
                if(word.charAt(j)!=words[i].charAt(j)) difference++;
            }
            if(difference==1){
                boolean[] visit=visited.clone();
                visit[i]=true;
                dfs(words[i],target,count+1,visit,words);
            }
        }
    }
}