class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] arr=new int[2001];
        for(int weight:weights){
            answer+=arr[weight]+arr[weight*2];
            if(weight%2==0) answer+=arr[weight/2]+arr[weight*3/2];
            if(weight%3==0) answer+=arr[weight*2/3]+arr[weight*4/3];
            if(weight%4==0) answer+=arr[weight*3/4];
            arr[weight]++;
        }
        return answer;
    }
}