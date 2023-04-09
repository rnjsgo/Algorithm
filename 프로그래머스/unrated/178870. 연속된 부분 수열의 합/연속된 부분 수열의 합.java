import java.util.*;
    
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0]=0;
        answer[1]=Integer.MAX_VALUE;
        int[] arr=new int[2];
        Queue<Integer> queue=new LinkedList<>();
        int sum=0, i=0;
        arr[0]=0;

        while(i<sequence.length){
            while(sum<=k&&i<sequence.length){
                sum+=sequence[i];
                queue.add(sequence[i]);
                if(sum==k){
                    arr[1]=i;
                    if(arr[1]-arr[0]<answer[1]-answer[0]){
                        answer[0]=arr[0];
                        answer[1]=arr[1];
                    }
                    else if(arr[1]-arr[0]==answer[1]-answer[0]){
                        if(arr[0]<answer[0]){
                            answer[0]=arr[0];
                            answer[1]=arr[1];
                        }
                    }
                }
                i++;
            }
            arr[1]=i-1;
            while(sum>k&&!queue.isEmpty()){
                sum-=queue.poll();
                arr[0]++;
                if(sum==k){
                    if(arr[1]-arr[0]<answer[1]-answer[0]){
                        answer[0]=arr[0];
                        answer[1]=arr[1];
                    }
                    else if(arr[1]-arr[0]==answer[1]-answer[0]){
                        if(arr[0]<answer[0]){
                            answer[0]=arr[0];
                            answer[1]=arr[1];
                        }
                    }
                }
            }
        }
        return answer;
    }
}