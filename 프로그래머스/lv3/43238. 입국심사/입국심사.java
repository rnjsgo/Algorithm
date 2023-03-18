class Solution {
    public long solution(int n, int[] times) {
        int minTime=Integer.MAX_VALUE;
        long answer=Long.MAX_VALUE;
        for(int t:times)
            minTime=Math.min(minTime,t);    
        long start=1;
        long end=(long)minTime*n;
        long mid=(start+end)/2;
        
        while(start<=end){
            mid=(start+end)/2;
            long possibleNum=0;
            for(int t:times)
                possibleNum+=mid/t;
            if(possibleNum<n)
                start=mid+1;
            else{
                end=mid-1;
                answer=Math.min(answer,mid);
            }
        }
        return start;
    }
}