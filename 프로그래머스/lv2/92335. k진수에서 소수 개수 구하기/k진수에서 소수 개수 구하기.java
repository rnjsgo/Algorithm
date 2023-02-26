class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder s=new StringBuilder();
        int start,end;
        int index=0;
        while(n!=0){
            s.insert(0,n%k);
            n/=k;
        }     
        while(index<s.length()){
            if(s.charAt(index)!='0'){
                start=index;
                StringBuilder a=makeString(start,s);
                if(checkPrime(a)){
                    if(start-1<0) answer++;
                    else if(start+a.length()==s.length()) answer++;
                    else answer++;
                }
                index+=a.length();
            }
            else index++;
        }
        return answer;
    }
    public StringBuilder makeString(int start,StringBuilder s){
        StringBuilder a=new StringBuilder();
        while(start<s.length()&&s.charAt(start)!='0'){
            a.append(s.charAt(start));
            start++;
        }
        return a;
    }
    public boolean checkPrime(StringBuilder s){
        long num=Long.parseLong(s.toString());
        if(num==1) return false;
        else{
            for(int i=2;i<=(int)Math.sqrt(num);i++){
                if(num%i==0)
                    return false;
            }
        }
        return true;
    }
}