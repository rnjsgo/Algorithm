import java.util.*;
class Solution {
    static int answer=0;
    
    public int solution(int n, int k) {
        String num = converter(n,k);
        String[] split = num.split("0");
        for(String s : split) isPrime(s);
        return answer;
    }
    
    public String converter(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n>=k){
            sb.append(n%k);
            n/=k;
        }
        sb.append(n);
        return sb.reverse().toString();
    }
    
    public void isPrime(String s){
        if(s.isEmpty()) return;
        long num = Long.parseLong(s);
        if(num==1) return;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return;
        }
        answer++;
    }
}