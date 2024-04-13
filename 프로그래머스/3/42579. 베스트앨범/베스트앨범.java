import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            
            if(!genreMap.containsKey(genre)){
                genreMap.put(genre, new Genre());
            }
            genreMap.get(genre).addMusic(new Music(i, plays[i]));
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(String genre : genreMap.keySet()){
            genreList.add(genreMap.get(genre));
        }
        
        Collections.sort(genreList, (a,b) -> b.getPlaycount() - a.getPlaycount());
        
        List<Integer> bestMusic = new ArrayList<>();
        
        for(Genre genre : genreList){
            int count = 0;
            ArrayList<Music> musicList = genre.getMusicList();
            
            Collections.sort(musicList, (a,b) -> {
                return (a.getPlaycount() == b.getPlaycount())? a.getNum() - b.getNum() : b.getPlaycount() - a.getPlaycount();
            });
            
            for(Music music : musicList){
                if(count == 2) break;
                bestMusic.add(music.getNum());
                count++;
            } 
        }
        
        int[] answer= new int[bestMusic.size()];
            for(int i=0; i<bestMusic.size(); i++){
                answer[i] = bestMusic.get(i);
        }
        return answer;
    }
}

class Genre{
    private ArrayList<Music> musicList;
    private int playcount;
    
    public Genre(){
        musicList = new ArrayList<>();
        this.playcount = 0;
    }
    
    public void addMusic(Music music){
        musicList.add(music);
        playcount += music.getPlaycount();
    }
    
    public int getPlaycount(){
        return playcount;
    }
    
    public ArrayList<Music> getMusicList(){
        return musicList;
    }
}

class Music{
    private int num;
    private int playcount;
    
    public Music(int num, int playcount){
        this.num = num;
        this.playcount = playcount;
    }
    
    public int getNum(){
        return num;
    }
    
    public int getPlaycount(){
        return playcount;
    }
}