class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day=0;
        for(int num:number)
            day+=num;
        for(int i=0;i<=discount.length-day;i++){
            int[] arr=number.clone();
            for(int j=i;j<i+day;j++){
                boolean isContain=false;
                for(int k=0;k<arr.length;k++){
                    if(discount[j].equals(want[k])){
                        arr[k]--;
                        isContain=true;
                    }
                }
                
                if(!isContain) break;  
            }
            boolean check=true;
            for(int k=0;k<arr.length;k++)
                    if(arr[k]!=0){
                        check=false;
                        break;
                    }
            if(check) answer++; 
        }
        return answer;
    }
}