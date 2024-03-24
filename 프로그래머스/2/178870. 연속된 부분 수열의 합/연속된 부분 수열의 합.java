import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        Queue<Integer> queue = new LinkedList<>();
        List<int[]> success = new ArrayList<>();
        long sum = 0;
        
        for(int i = 0 ; i < sequence.length ; i++){
            queue.add(sequence[i]);
            sum += sequence[i];
            
            if(sum > k){
                while(sum >= k){
                    if(sum == k){
                        int[] s = {i-queue.size()+1, i};
                        success.add(s);
                        break;
                    } 
                    sum -= queue.poll();
                }
            }
            else if(sum == k){
                int[] s = {i-queue.size()+1, i};
                success.add(s);
            }
        }
        
        Collections.sort(success,(a,b)->{
            int lengthA=(a[1]-a[0]);
            int lengthB= (b[1]-b[0]);
            return (lengthA - lengthB == 0) ? a[0] - b[0] : lengthA - lengthB;  
        });
            
        return success.get(0);
    }
}