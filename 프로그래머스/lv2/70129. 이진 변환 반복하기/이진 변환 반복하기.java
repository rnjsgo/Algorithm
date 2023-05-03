class Solution {
    public int[] solution(String s) {
        int[] answer=new int[2];
        while(!s.equals("1")){
            while(s.contains("0")){
                s=s.replaceFirst("0","");
                answer[1]++;
            }
            answer[0]++;
            s=Integer.toString(s.length(),2);
        }

        return answer;
    }
}