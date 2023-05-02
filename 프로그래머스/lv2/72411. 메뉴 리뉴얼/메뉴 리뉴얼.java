import java.util.*;
class Solution {
    Map<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> result=new ArrayList<>();
        
        for(int c:course){
            map=new HashMap<>();
            
            for(String s:orders){
                char[] sort=s.toCharArray();
                Arrays.sort(sort);
                comb("",String.valueOf(sort),0,c);
            }
            
            int max=Integer.MIN_VALUE;
            for(String s:map.keySet()){
                max=Math.max(max,map.get(s));
            }
            
            for(String s:map.keySet()){
                if(map.get(s)==max&&map.get(s)>=2) result.add(s);
            }
        }
        
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i=0;i<result.size();i++)
            answer[i]=result.get(i);
        
        return answer;
    }
    
    public void comb(String menu,String order,int depth,int course){
        if(menu.length()==course){
            map.put(menu,map.getOrDefault(menu,0)+1);
            return;
        }
        if(depth==order.length()) return;
        
        comb(menu+order.charAt(depth),order,depth+1,course);
        comb(menu,order,depth+1,course);
    }
}