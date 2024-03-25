import java.util.*;

class Solution {
    List<int[]> saleList = new ArrayList<>();
    int maxJoinUser = Integer.MIN_VALUE;
    int maxIncome = Integer.MIN_VALUE;
    final int[] rate = {10, 20 ,30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        makeSaleList(new int[emoticons.length], 0, emoticons.length);
        
        for(int[] s : saleList){
            int join = 0;
            int money = 0;
            for(int[] u : users){
                int price = 0;
                boolean isJoin = false;
                for(int i=0; i<emoticons.length; i++){
                    if(s[i] >= u[0]) price += (100 - s[i]) * emoticons[i] / 100;
                    if(price >= u[1]){
                        join++;
                        isJoin = true;
                        break;
                    }
                }
                if(!isJoin) money += price;
            }
            if(maxJoinUser < join){
                maxJoinUser = join;
                maxIncome = money;
            }
            else if(maxJoinUser == join) maxIncome = Math.max(maxIncome, money);
        }
        
        int[] answer = {maxJoinUser, maxIncome};
        return answer;
    }
    
    public void makeSaleList(int[] sales, int count, int length){
        if(count == length){
            saleList.add(sales);
            return;
        }
        for(int i=0 ; i<4 ; i++){
            sales[count] = rate[i];
            makeSaleList(sales.clone(), count+1, length);
        }
    }
}