class Solution {
    public int solution(int n, long l, long r) {   
        long[] arr=new long[20];
        long a=1;
        for(int i=0;i<20;i++){
            arr[i]=a;
            a*=4;
        }
        return (int)(sum(r,n,arr)-sum(l-1,n,arr));
    }
    public long sum(long num,int n,long[] arr){
        long result=0;
        long quotient=num/(long)Math.pow(5,n-1);
        long remainder=num%(long)Math.pow(5,n-1);
        while(true){
            for(int i=1;i<=quotient;i++){
                if(i==3) continue;
                result+=arr[n-1];
            }
            if(quotient!=2&&n>1){
                if(remainder<=5){
                    for(int i=1;i<=remainder;i++){
                        if(i==3) continue;
                        result+=1;
                    }
                    break;
                }
                else{
                    quotient=remainder/(long)Math.pow(5,n-2);
                    remainder=remainder%(long)Math.pow(5,n-2);
                    n--;                    
                }
            }
            else break;
        }
        return result;
    }
}