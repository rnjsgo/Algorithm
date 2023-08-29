import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){
            int days = Integer.parseInt(br.readLine());
            String[] priceList = br.readLine().split(" ");
            long benefit = 0;
            int maxPrice = Integer.parseInt(priceList[priceList.length-1]);

            for(int j=days-2; j>=0; j--){
                int price = Integer.parseInt(priceList[j]);

                if(price <= maxPrice) benefit += maxPrice - price;
                else maxPrice = price ;
            }
            System.out.println(benefit);
        }
    }
}
