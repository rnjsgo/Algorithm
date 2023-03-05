class Solution {
    static int count=0;
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean[] check=new boolean[book_time.length];
        
        while(count!=book_time.length){
            answer++;
            String findNext="00:00";
            while(findNext!="0")
                findNext=findBook(findNext,book_time,check);      
        }
        return answer;
    }
    static public String findBook(String findNext,String[][] book_time,boolean[] check){
        int[] select={24,60};
        int afterHour=Integer.parseInt(findNext.split(":")[0]);
        int afterMinute=Integer.parseInt(findNext.split(":")[1]);
        int findIndex=-1;
        for(int i=0;i<book_time.length;i++){
            int hour=Integer.parseInt(book_time[i][0].split(":")[0]);
            int minute=Integer.parseInt(book_time[i][0].split(":")[1]);
            if(!check[i]&&hour<select[0]&&hour>=afterHour){
                if(hour==afterHour){
                    if(minute<afterMinute) continue;
                }
                select[0]=hour;
                select[1]=minute;
                findIndex=i;
            }
            else if(!check[i]&&hour==select[0]&&hour>=afterHour){
                if(hour==afterHour){
                    if(minute<afterMinute) continue;
                }
                if(minute<select[1]){
                    select[1]=minute;
                    findIndex=i;
                }
            }
        }
        if(findIndex==-1) return "0";
        else{
            count++;
            check[findIndex]=true;
            int findNextHour=Integer.parseInt(book_time[findIndex][1].split(":")[0]);
            int findNextMinute=Integer.parseInt(book_time[findIndex][1].split(":")[1]);
            if(findNextMinute+10>=60){
                findNextHour+=1;
                findNextMinute-=50;
            }
            else findNextMinute+=10;
            return findNextHour+":"+findNextMinute;
        }
    }
}