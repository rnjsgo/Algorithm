import java.util.*;
class Solution {
    static int[] sales;
    static ArrayList<int[]> saleArr=new ArrayList<>();
    static int[] rates={10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0,0};
        sales=new int[emoticons.length];
        int resultJoin=0;
        int resultMoney=0;     
        makeSales(0,emoticons.length);
        for(int i=0;i<saleArr.size();i++){
            int join=0;
            int money=0;
            for(int j=0;j<users.length;j++){
                int personMoney=0;
                for(int k=0;k<emoticons.length;k++){
                    if(users[j][0]<=saleArr.get(i)[k])
                        personMoney+=emoticons[k]*(100-saleArr.get(i)[k])/100;
                }
                if(personMoney>=users[j][1]) join++;
                else money+=personMoney;
            }
            if(resultJoin<join){
                resultJoin=join;
                resultMoney=money;
            }
            else if(resultJoin==join){
                if(resultMoney<money) resultMoney=money;
            }
        }
        answer[0]=resultJoin;
        answer[1]=resultMoney;
        return answer;
    }
   
    public static void makeSales(int count,int length){
        if(count==length){
            saleArr.add(sales.clone());
            return;
        }
        for(int i=0;i<4;i++){
            sales[count]=rates[i];
            makeSales(count+1,length);
        }
    }
}