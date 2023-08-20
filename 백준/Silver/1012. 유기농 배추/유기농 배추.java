import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class position{
    int x,y;
    position(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int arr[][];
    static boolean visit[][];
    static int[] searchX = {-1, 1, 0, 0};
    static int[] searchY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int result[] = new int[test];
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());
            arr = new int[x][y];
            visit = new boolean[x][y];

            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine());
                int xx = Integer.parseInt(st.nextToken());
                int yy = Integer.parseInt(st.nextToken());
                arr[xx][yy] = 1;
            }
            for (int a = 0; a < x; a++) {
                for (int b = 0; b < y; b++) {
                    if (arr[a][b] == 1 && !visit[a][b]) {
                        bfs(a, b);
                        result[i]++;
                    }
                }
            }
        }

        for (int r : result)
            System.out.println(r);

    }

    static void bfs(int x, int y) {
        position pos = new position(x, y);
        Queue<position> que = new LinkedList<>();
        que.add(pos);

        while(!que.isEmpty()){
            position pos1=que.poll();
            visit[pos1.x][pos1.y]=true;
            for(int i=0;i<4;i++){
                int px=pos1.x+searchX[i];
                int py=pos1.y+searchY[i];

                if(px>=0&&px<arr.length&&py>=0&&py<arr[0].length){
                    if(arr[px][py]==1&&!visit[px][py]){
                        position pos2=new position(px,py);
                        que.add(pos2);
                        visit[px][py]=true;
                    }
                }
            }
    }
}




}