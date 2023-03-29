import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<int[]> arr=new ArrayList<>();
        for(int[] route:routes)
            arr.add(route);
        Collections.sort(arr,(a,b)->a[1]-b[1]);
        while(!arr.isEmpty()){
            int end=arr.get(0)[1];
            arr.remove(0);
            answer++;
            while(!arr.isEmpty()&&arr.get(0)[0]<=end)
                arr.remove(0);
        }
        return answer;
    }
}