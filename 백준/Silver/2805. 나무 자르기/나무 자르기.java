import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int need = Integer.parseInt(input[1]);
        String[] arr = br.readLine().split(" ");
        int[] trees = new int[arr.length];
        for(int i=0; i<trees.length; i++){
            trees[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(trees);
        long start = 0;
        long end = trees[trees.length-1];
        long mid=0;
        while(start<=end) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }
            if (sum >= need) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(end);
    }

}
