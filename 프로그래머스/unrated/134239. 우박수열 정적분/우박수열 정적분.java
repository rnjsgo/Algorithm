import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> area=woobak(k);
        for(int i=0;i<ranges.length;i++){
            double result=0.0;
            if(ranges[i][0]>area.size()+ranges[i][1])
                result=-1.0;
            else{
                for(int j=ranges[i][0];j<area.size()+ranges[i][1];j++)
                    result+=area.get(j);
            }
            answer[i]=result;
        }
        return answer;
    }
    public ArrayList<Double> woobak(int k){
        ArrayList<Integer> sequence=new ArrayList<>();
        sequence.add(k);
        while(k>1){
            if(k%2==0) k/=2;
            else k=k*3+1;
            sequence.add(k);
        }
        
        ArrayList<Double> area=new ArrayList<>();
        for(int i=0;i<sequence.size()-1;i++)
            area.add((double)(sequence.get(i)+sequence.get(i+1))/2);
   
        return area;
    }
}