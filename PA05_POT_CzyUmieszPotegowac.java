import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA05_POT_CzyUmieszPotegowac{
    public static void main(String[] args) throws IOException{

        int numOfSets, lastDigit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] numTab;

//        number of sets
        numOfSets = Integer.parseInt(br.readLine());

        for (int i = 0; i <numOfSets; i++){
//        Enter base and then exponent of the power
            numTab = br.readLine().split(" ");
            lastDigit = getLastFromResult(Integer.parseInt(numTab[0]), Integer.parseInt(numTab[1]));
            sb.append(lastDigit + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int getLastFromResult(int base, int exponent){
        if (exponent==0 ){
            return 1;
        }
        base %= 10;
        exponent %= 4;
        exponent = (exponent==0) ? 4 : exponent;

        int result = (int)Math.pow(base, exponent)%10;
        return result;
    }
}
