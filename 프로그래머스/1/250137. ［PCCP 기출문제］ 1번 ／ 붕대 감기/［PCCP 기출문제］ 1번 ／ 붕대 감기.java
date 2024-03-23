class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 1, attackIndex = 0, bandcount = 0, maxhealth = health;
        
        while(attackIndex < attacks.length){
            if(time == attacks[attackIndex][0]){
                health -= attacks[attackIndex][1];
                if(health <= 0) return -1;
                bandcount = 0;
                attackIndex++;
            } else{
                bandcount++;
                health += bandage[1];
                if(bandcount == bandage[0]){
                    health += bandage[2];
                    bandcount = 0 ;
                }
                if(health > maxhealth) health = maxhealth;
            }
            
            time++;
        }
        
        return health;
    }
}