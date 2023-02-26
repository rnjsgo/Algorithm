import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        List<Integer> divisorA=findDivisor(arrayA);
        List<Integer> divisorB=findDivisor(arrayB);
        for(int i=0;i<divisorA.size();i++){
            boolean pass=true;
            for(int j=0;j<arrayB.length;j++){
                if(arrayB[j]%divisorA.get(i)==0){
                    pass=false;
                    break;
                }
            }
            if(pass){
                answer=divisorA.get(i);
                break;
            } 
        }
        for(int i=0;i<divisorB.size();i++){
            boolean pass=true;
            for(int j=0;j<arrayA.length;j++){
                if(arrayA[j]%divisorB.get(i)==0){
                    pass=false;
                    break;
                }
            }
            if(pass){
                answer=Math.max(answer,divisorB.get(i));
                break;
            } 
        }
        return answer;
    }
    public List<Integer> findDivisor(int[] arr){
        List<Integer> divisor=new ArrayList<>();
        for(int i=1;i<=Math.sqrt(arr[0]);i++){
            if(arr[0]%i==0){
                divisor.add(arr[0]/i);
            }
        }
        for(int i=divisor.size()-1;i>=0;i--)
            divisor.add(arr[0]/divisor.get(i));
        
        List<Integer> commonDivisor=new ArrayList<>();
        for(int i=0;i<divisor.size();i++){
            boolean isCommon=true;
            for(int j=1;j<arr.length;j++){
                if(arr[j]%divisor.get(i)!=0){
                    isCommon=false;
                    break;
                }
            }
            if(isCommon) commonDivisor.add(divisor.get(i));
        }
        return commonDivisor;
    }
}