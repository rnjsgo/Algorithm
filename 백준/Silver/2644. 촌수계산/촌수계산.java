
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean find;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        ArrayList[] list = new ArrayList[Integer.parseInt(br.readLine())+1];

        for(int i = 1 ; i<list.length ; i++){
            list[i] = new ArrayList<Integer>();
        }

        String[] search = br.readLine().split(" ");
        int start = Integer.parseInt(search[0]);
        int end = Integer.parseInt(search[1]);

        int links = Integer.parseInt(br.readLine());
        for(int i=0; i<links; i++){
            String[] link =br.readLine().split(" ");
            int parent = Integer.parseInt(link[0]);
            int child = Integer.parseInt(link[1]);
            list[parent].add(child);
            list[child].add(parent);
        }
        boolean[] visited = new boolean[list.length];
        dfs(start, end, 0, list, visited);
        if(!find) System.out.println(-1);
    }

    public static void dfs(int start, int end, int depth, ArrayList[] list, boolean[] visited){
        depth++;
        visited[start] = true;
        List<Integer> here = list[start];
        for(int i =0 ; i<here.size(); i++){
            if(here.get(i)==end){
                System.out.println(depth);
                find = true;
                return;
            }
            else if(!visited[here.get(i)]){
                dfs(here.get(i), end, depth, list, visited);
            }
        }
    }
}
