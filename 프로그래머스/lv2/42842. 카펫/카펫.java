class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size=brown+yellow;
        for(int i=3;i<=Math.sqrt(size);i++){
            if((size)%i==0){
                int garo=(size)/i;
                int sero=i;
                if(yellow==(garo-2)*(sero-2)){
                    answer[0]=garo;
                    answer[1]=sero;
                    break;
                }
            }
        }
        return answer;
    }
}