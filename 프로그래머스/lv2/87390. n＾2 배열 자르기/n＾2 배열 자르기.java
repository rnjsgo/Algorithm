class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int[] arr=new int[n];
        int index=0;
        for(int i=0;i<n;i++)
            arr[i]=i+1;
        for(;left<=right;left++){
            int a=(int)((left)%n);
            int b=(int)((left)/n);
            if(a<b) answer[index]=arr[a]+b-a;
            else answer[index]=arr[a];
            index++;
        }
        return answer;
    }
}