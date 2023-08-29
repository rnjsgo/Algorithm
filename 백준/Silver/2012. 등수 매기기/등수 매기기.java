
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr= new int[count];
        long sum = 0;
        for(int i=0; i<count; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0;i<count;i++){
            sum+=Math.abs(i+1-arr[i]);
        }
        System.out.println(sum);
    }
}
