import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> CS =new HashMap<>();
        Map<Integer,Integer> bro =new HashMap<>();
        for(int i=0;i<topping.length/2;i++){
            if(CS.containsKey(topping[i])) 
                CS.put(topping[i],CS.get(topping[i])+1);
            else
                CS.put(topping[i],1);
        }
        for(int i=topping.length/2;i<topping.length;i++)
            if(bro.containsKey(topping[i])) 
                bro.put(topping[i],bro.get(topping[i])+1);
            else
                bro.put(topping[i],1);
        if(CS.size()==bro.size()) answer--;

        answer+=check(-1,CS,bro,topping.length/2-1,topping);
        answer+=check(1,CS,bro,topping.length/2,topping);
        return answer;
    }
    
    public int check(int dir,Map<Integer,Integer> chulsoo,Map<Integer,Integer> brother,int index,int[] topping){
        Map<Integer,Integer> CS=new HashMap<>(chulsoo);
        Map<Integer,Integer> bro=new HashMap<>(brother);
        int count=0;
        boolean balance=false;

        while(index>=0&&index<topping.length){
            if(dir==-1&&CS.size()<bro.size()) break;
            if(dir==1&&CS.size()>bro.size()) break;
            if(CS.size()==bro.size()){
                balance=true;
                count++;
                if(dir==-1){
                    if(CS.get(topping[index])>1)
                        CS.put(topping[index],CS.get(topping[index])-1);
                    else CS.remove(topping[index]);
                    if(bro.containsKey(topping[index]))
                        bro.put(topping[index],bro.get(topping[index])+1);
                    else bro.put(topping[index],1);           
                }
                else{
                    if(CS.containsKey(topping[index]))
                        CS.put(topping[index],CS.get(topping[index])+1);
                    else CS.put(topping[index],1);
                    if(bro.get(topping[index])>1)
                        bro.put(topping[index],bro.get(topping[index])-1);
                    else bro.remove(topping[index]); 
                }
                index+=dir;
            }
            else{
                if(balance==true) break;
                else{
                    if(dir==-1){
                    if(CS.get(topping[index])>1)
                        CS.put(topping[index],CS.get(topping[index])-1);
                    else CS.remove(topping[index]);
                    if(bro.containsKey(topping[index]))
                        bro.put(topping[index],bro.get(topping[index])+1);
                    else bro.put(topping[index],1);           
                }
                else{
                    if(CS.containsKey(topping[index]))
                        CS.put(topping[index],CS.get(topping[index])+1);
                    else CS.put(topping[index],1);
                    if(bro.get(topping[index])>1)
                        bro.put(topping[index],bro.get(topping[index])-1);
                    else bro.remove(topping[index]); 
                }
                    index+=dir;
                }
            }
        }
        return count;
    }
}