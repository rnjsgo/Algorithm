import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> arrList = new ArrayList<>();
        int sum = 0;
        int[] result = {0, 0};
        
        for(int i=0; i<sequence.length; i++){
            result[1] = i;
            sum += sequence[i];
            if(sum < k) continue;
            else if(sum > k){
                while(sum > k){
                    sum -= sequence[result[0]];    
                    result[0]++;
                    if(sum == k) arrList.add(result.clone());
                }
            }
            else arrList.add(result.clone());
        }
        
        Collections.sort(arrList, (a, b)->{
            int lengthA = a[1] - a[0];
            int lengthB = b[1] - b[0];
            return (lengthA == lengthB)? a[0] - b[0] : lengthA - lengthB;
        });

        return arrList.get(0);
    }
}