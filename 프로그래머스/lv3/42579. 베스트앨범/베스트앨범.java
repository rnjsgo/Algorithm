import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map=new HashMap<>();
        List<Genre> arr=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<genres.length;i++)
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        for(String s:map.keySet())
            arr.add(new Genre(s,map.get(s)));
        Collections.sort(arr,(a,b)->b.plays-a.plays);
        for(Genre g:arr){
            List<Play> play=new ArrayList<>();
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(g.genre)) play.add(new Play(i,plays[i]));
            }
            Collections.sort(play,(a,b)->b.play-a.play);
            for(int i=0;i<2;i++){
                if(play.size()==1){
                    result.add(play.get(i).index);
                    break;
                }
                result.add(play.get(i).index);
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) answer[i]=result.get(i);
        return answer;
    }
}
class Genre{
    String genre;
    int plays;
    Genre(String genre,int plays){
        this.genre=genre;
        this.plays=plays;
    }
}
class Play{
    int index;
    int play;
    Play(int index,int play){
        this.index=index;
        this.play=play;
    }
}