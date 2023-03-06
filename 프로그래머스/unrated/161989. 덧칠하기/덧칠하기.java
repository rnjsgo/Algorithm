class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index=0;
        while(index<section.length){
            answer++;
            int num=section[index]+m;
            while(index<section.length&&section[index]<num) index++;
        }
        return answer;
    }
}