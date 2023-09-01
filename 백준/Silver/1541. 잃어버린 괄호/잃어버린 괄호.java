

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int state = 1;
        for(int i=0; i<expression.length(); i++){
            char s = expression.charAt(i);
            if(s=='+'){
                sum+=Integer.parseInt(sb.toString())*state;
                sb = new StringBuilder();
            }
            else if(s=='-'){
                sum+=Integer.parseInt(sb.toString())*state;
                sb = new StringBuilder();
                state = -1;
            }
            else{
                sb.append(s);
            }
        }
        sum+=Integer.parseInt(sb.toString())*state;
        System.out.println(sum);
    }
}
