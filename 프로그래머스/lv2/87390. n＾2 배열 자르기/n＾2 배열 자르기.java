class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        for(long i=left;i<=right;i++){
            long c = i/n;
            long r = i%n;
            answer[(int)(i-left)] = r<c ? (int)c+1 : (int)r+1 ;
        }
        return answer;
    }
}