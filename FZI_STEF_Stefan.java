import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FZI_STEF_Stefan {

    public static int incomeTab[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        enterData(br);
        br.close();

        System.out.println(calcMaxIncome());
    }
    // w ramach zmniejszenia czytelności i zwiększenia szybkości działania wszystko można wrzucić w jedną klasę (jedna pętla "for" mniej)
    public static void enterData(BufferedReader br) throws IOException {
        int numOfCities = Integer.parseInt(br.readLine());
        incomeTab = new int[numOfCities];
        for (int i = 0; i<numOfCities; i++){
            incomeTab[i] = Integer.parseInt(br.readLine());
        }
    }

    public static long calcMaxIncome() {
        long income=0, maxIncome=0;

        for(int i =0; i<incomeTab.length; i++){
            income += incomeTab[i];

            if (income > maxIncome) {
                maxIncome = income;
            } else {
                income = 0;
            }
        }
        return maxIncome;
    }
}