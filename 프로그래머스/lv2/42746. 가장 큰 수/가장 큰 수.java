import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        Integer[] arr=new Integer[numbers.length];
        for(int i=0;i<numbers.length;i++)
            arr[i]=numbers[i];

        Arrays.sort(arr,(a,b)->{
            String A=String.valueOf(a);
            String B=String.valueOf(b);
            return Integer.parseInt(B+A)-Integer.parseInt(A+B);
        });
        StringBuilder s=new StringBuilder();
        if(arr[0]==0) return "0";
        for(int i:arr)
            s.append(i);
        
        return s.toString();
    }
}