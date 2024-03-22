class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = section[0];
        
        for(int s : section){
            if(index > s) continue;
            else{
                index=s+m;
                answer++;
            }
        }
        return answer;
    }
}