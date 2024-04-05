import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] oil;
    static Set<Integer> set;
    
    static class Data {
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        arr = land;
        visit = new boolean[N][M];
        oil = new int[M];
        
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        int answer = 0;
        for(int i : oil) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
    
    private static void bfs(int x, int y) {
        int cnt = 1; 
        Queue<Data> q = new ArrayDeque<>();
        q.offer(new Data(x,y));
        visit[x][y] = true;
        set = new HashSet<>(); 
        set.add(y);
        
        while(!q.isEmpty()) {
            Data cur = q.poll();
            for(int k = 0; k<4; k++) {
                int nx = cur.x+dx[k];
                int ny = cur.y+dy[k];
                
                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    if(arr[nx][ny] == 1 && !visit[nx][ny]) {
                        q.offer(new Data(nx, ny));
                        visit[nx][ny] = true;
                        set.add(ny);
                        cnt++;
                    }
                }
            }
        }
        
        for(int s: set) {
            oil[s] += cnt;
        }
    }
}