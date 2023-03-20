import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]> arr=new ArrayList<>();
        List<Integer> visited=new ArrayList<>();

        for(int[] a:costs)
            arr.add(a);
        Collections.sort(arr,(a,b)->a[2]-b[2]);
        
        visited.add(arr.get(0)[0]);
        visited.add(arr.get(0)[1]);
        answer+=arr.get(0)[2];
        arr.remove(0);
        while(visited.size()<n){
            for(int i=0;i<arr.size();i++){
                if(visited.contains(arr.get(i)[0])||visited.contains(arr.get(i)[1])){
                    if(visited.contains(arr.get(i)[0])&&visited.contains(arr.get(i)[1])) continue;
                    if(!visited.contains(arr.get(i)[0])) visited.add(arr.get(i)[0]);
                    if(!visited.contains(arr.get(i)[1])) visited.add(arr.get(i)[1]);
                    answer+=arr.get(i)[2];
                    arr.remove(i);
                    break;
                }
            }
        }
        
        return answer;
    }
}