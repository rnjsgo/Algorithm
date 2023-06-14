class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                if(park[i].charAt(j)=='S'){
                    answer[0]=i;
                    answer[1]=j;
                    break;
                }
            }
        }
        
        for(String route:routes){
            String[] r=route.split(" ");
            go(answer,r,park);
        }
        return answer;
    }
    public void go(int[] answer,String[] route, String[] park){
        int count=Integer.parseInt(route[1]);
        if(route[0].equals("N")&&answer[0]-count>=0){
            for(int i=1;i<=count;i++){
                if(park[answer[0]-i].charAt(answer[1])=='X') return;
            }            
            answer[0]-=count;
        }
        else if(route[0].equals("S")&&answer[0]+count<park.length){
            for(int i=1;i<=count;i++){
                if(park[answer[0]+i].charAt(answer[1])=='X') return;
            }
            answer[0]+=count;
        }
        else if(route[0].equals("W")&&answer[1]-count>=0){
            for(int i=1;i<=count;i++){
                if(park[answer[0]].charAt(answer[1]-i)=='X') return;
            }
            answer[1]-=count;
        }
        else if(route[0].equals("E")&&answer[1]+count<park[0].length()){
            for(int i=1;i<=count;i++){
                if(park[answer[0]].charAt(answer[1]+i)=='X') return;
            }
            answer[1]+=count;
        }
    }
}