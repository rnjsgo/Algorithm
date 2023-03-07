class Solution {
    static int answer=Integer.MAX_VALUE;
    public int solution(String name) {
        dfs(0,0,0,new boolean[name.length()],name);
        return answer;
    }
    public static void dfs(int index,int move,int count,boolean[] visit,String name){
        boolean[] visited=visit.clone();       
        visited[index]=true;
            if(name.charAt(index)!='A'){
                if(name.charAt(index)-'A'<14)
                    count+=name.charAt(index)-'A';
                else 
                    count+=26-(name.charAt(index)-'A');
                count+=move;
                move=0;
            }
        
        boolean hasNext=false;
        int next;
        for(int i=1;i<name.length();i++){
            if(index+i>=name.length()) next=index+i-name.length();
            else next=index+i;
            if(name.charAt(next)!='A'&&!visited[next]){
                dfs(next,i,count,visited,name);
                hasNext=true;
                break;
            }
        }
        
        for(int i=1;i<name.length();i++){
            if(index-i<0) next=name.length()+index-i;
            else next=index-i;
            if(name.charAt(next)!='A'&&!visited[next]){
                dfs(next,i,count,visited,name);
                hasNext=true;
                break;
            }
        }

        if(!hasNext) answer=Math.min(answer,count);
        

    }
}