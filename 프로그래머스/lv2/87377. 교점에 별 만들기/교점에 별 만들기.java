import java.util.*;

class Solution {
    class Coordinate{
        long x;
        long y;
        Coordinate(long x,long y){
            this.x=x;
            this.y=y;
        }
    }
    public String[] solution(int[][] line) {
        String[] answer;
        ArrayList<Coordinate> coordinate=new ArrayList<>();
        long minX=Long.MAX_VALUE;
        long minY=Long.MAX_VALUE;
        long maxX=Long.MIN_VALUE;
        long maxY=Long.MIN_VALUE;
        
        for(int i=0;i<line.length;i++){
            for(int j=i+1;j<line.length;j++){
                long adbc=((long)line[i][0]*(long)line[j][1])-((long)line[i][1]*(long)line[j][0]);
                if(adbc==0) continue;
                double x=(((long)line[i][1]*(long)line[j][2])-((long)line[i][2]*(long)line[j][1]))/(double)adbc;
                double y=(((long)line[i][2]*(long)line[j][0])-((long)line[i][0]*(long)line[j][2]))/(double)adbc;
                if(x-(long)x==0&&y-(long)y==0){
                    coordinate.add(new Coordinate((long)x,(long)y));
                    minX=Math.min(minX,(long)x);    
                    minY=Math.min(minY,(long)y);
                    maxX=Math.max(maxX,(long)x);
                    maxY=Math.max(maxY,(long)y);
                }
            }
        }
        long sizeX=maxX-minX+1;
        long sizeY=maxY-minY+1;
        
        answer=new String[(int)sizeY];
        boolean star[][]=new boolean[(int)sizeY][(int)sizeX];
        for(Coordinate c:coordinate)
            star[(int)(maxY-c.y)][(int)(c.x-minX)]=true;
        
        for(int i=0;i<(int)sizeY;i++){
            StringBuilder s=new StringBuilder();
            for(int j=0;j<(int)sizeX;j++){
                if(star[i][j]==true)
                    s.append("*");
                else
                    s.append(".");
            }
            answer[i]=s.toString();
        }
        return answer;
    }
}