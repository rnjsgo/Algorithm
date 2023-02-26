class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i<=d;i+=k){
            long max=(long)Math.sqrt((long)d*(long)d-(long)i*(long)i);
            answer+=max/k+1;
        }
        return answer;
    }
}