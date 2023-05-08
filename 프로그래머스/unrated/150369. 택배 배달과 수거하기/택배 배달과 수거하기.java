class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery=n-1, pickup=n-1;
        while(delivery>=0||pickup>=0){
            while(delivery>=0){
                if(deliveries[delivery]==0) delivery--;
                else break;
            }
            while(pickup>=0){
                if(pickups[pickup]==0) pickup--;
                else break;
            }
        
            long distance=Math.max(delivery,pickup)+1;
            answer+=distance*2;
            int left=cap;
            while(left>0&&delivery>=0){
                if(deliveries[delivery]>left){
                    deliveries[delivery]-=left;
                    break;
                }
                else {
                    left-=deliveries[delivery];
                    delivery--;
                }
            }
            left=cap;
            while(left>0&&pickup>=0){
                if(pickups[pickup]>left){
                    pickups[pickup]-=left;
                    break;
                }
                else {
                    left-=pickups[pickup];
                    pickup--;
                }
            }
        }
        
        return answer;
    }
}