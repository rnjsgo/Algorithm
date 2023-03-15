class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] weight=new int[241];
        for(int n:people)
            weight[n]++;
        for(int i=40;i<241;i++){
            if(weight[i]!=0){
                weight[i]--;
                answer++;
                for(int j=limit-i;j>=40;j--){
                    if(weight[j]!=0){
                        weight[j]--;
                        break;
                    }
                }
                i--;
            }
        }
        return answer;
    }
}