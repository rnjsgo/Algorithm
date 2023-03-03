class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        while(n>0){
            if(deliveries[n-1]==0&&pickups[n-1]==0){
                n--;
                continue;
            }
            else{
                int truck=0;
                for(int i=1;n-i>=0;i++){
                    if(deliveries[n-i]==0) continue;
                    if(truck+deliveries[n-i]>cap){
                        deliveries[n-i]-=cap-truck;
                        break;
                    }
                    else{
                        truck+=deliveries[n-i];
                        deliveries[n-i]=0;
                    } 
                }
                truck=0;
                for(int i=1;n-i>=0;i++){
                    if(pickups[n-i]==0) continue;
                    if(truck+pickups[n-i]>cap){
                        pickups[n-i]-=cap-truck;
                        break;
                    }
                    else{
                        truck+=pickups[n-i];
                        pickups[n-i]=0;
                    } 
                }
            }
            answer+=n*2;
        }
        
        return answer;
    }
}