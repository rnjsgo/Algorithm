import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr=new Integer[citations.length];
        for(int i=0;i<citations.length;i++)
            arr[i]=citations[i];
        Arrays.sort(arr,(a,b)->b-a);
        for(int i=arr[0];i>=0;i--){
            int citation=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i) citation++;
            }
            if(citation>=i&&citations.length-citation<=i){
                answer=i;
                break;
            }
        }
        return answer;
    }
}