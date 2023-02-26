import java.util.*;
class Solution {
    Map<String,ArrayList<Integer>> map=new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String s:info)
            dfs("",0,s.split(" "));
        for(String key:map.keySet())
            Collections.sort(map.get(key));
        for(int i=0;i<query.length;i++){
            String s=query[i].replaceAll(" and ","");
            String[] required=s.split(" ");
            if(map.containsKey(required[0])){
                ArrayList<Integer> arr=map.get(required[0]);
                int score=Integer.parseInt(required[1]);
                int start=0;
                int end=arr.size()-1;
                while(start<=end){
                    int mid=(end+start)/2;
                    if(arr.get(mid)<score)
                        start=mid+1;
                    else
                        end=mid-1;
                }
                answer[i]=arr.size()-start;
            }                
        }

        return answer;
    }
    public void dfs(String str,int depth,String[] info){
        if(depth==4)
        {
            if(map.containsKey(str))
                map.get(str).add(Integer.parseInt(info[4]));
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(Integer.parseInt(info[4]));
                map.put(str,arr);
            }      
            return;
        }
        dfs(str+info[depth],depth+1,info);
        dfs(str+"-",depth+1,info);
    }
}