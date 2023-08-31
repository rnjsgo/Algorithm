

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int sum = 0;
        int max =Integer.MIN_VALUE;

        for(int i=0; i<count; i++){
            int num = Integer.parseInt(arr[i]);
            sum += num;
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
        }
        System.out.println(max);
    }
}
