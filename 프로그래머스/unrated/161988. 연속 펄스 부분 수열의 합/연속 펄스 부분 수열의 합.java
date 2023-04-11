class Solution {
    public long solution(int[] sequence) {
        long answer = Math.max(sequence[0],-sequence[0]);
        int[] arr1=new int[sequence.length];
        int[] arr2=new int[sequence.length];
        long[] dp1=new long[sequence.length];
        long[] dp2=new long[sequence.length];
        
        int pulse=1;
        for(int i=0;i<sequence.length;i++){
            arr1[i]=sequence[i]*pulse;
            arr2[i]=sequence[i]*(-pulse);
            pulse*=-1;
        }
        
        dp1[0]=arr1[0];
        dp2[0]=arr2[0];

        for(int i=1;i<sequence.length;i++){
            if(arr1[i]+dp1[i-1]>arr1[i]) dp1[i]=arr1[i]+dp1[i-1];
            else dp1[i]=arr1[i];
            
            if(arr2[i]+dp2[i-1]>arr2[i]) dp2[i]=arr2[i]+dp2[i-1];
            else dp2[i]=arr2[i];
            
            answer=Math.max(answer,dp1[i]);
            answer=Math.max(answer,dp2[i]);
        }
        return answer;
    }
}