class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long R1= (long)Math.pow(r1,2);
        long R2= (long)Math.pow(r2,2);
        
        for(int i=0;i<r2;i++){
            double countR1=Math.sqrt(R1-Math.pow(i,2));
            double countR2=Math.sqrt(R2-Math.pow(i,2));
            answer+=4*((int)countR2-(int)countR1);
            if(countR1%1==0&&countR1!=0) answer+=4;
        }
        return answer;
    }
}