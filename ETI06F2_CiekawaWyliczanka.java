import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class ETI06F2_CiekawaWyliczanka {
    // the programme is based on geometric sequence, so a1, q and n(called "group") are variables concerning the sequence
    public static int a1=2, group = 1, q=2;       // variables concerning the geometric sequence
    public static int sum = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        countDigitsInNumber(k);
        System.out.println(determineNumber(k));

    }

    // check how many digits are in the number using formula for n-element of geometric sequence
    // n-element ("group") defines amount of digits to display
    public static void countDigitsInNumber(int k ){
        while( (sum += a1*(int)Math.pow(q, group-1)) < k ) {
            group++;
        }
    }


    public static String determineNumber(int k){
        StringBuilder sb = new StringBuilder();

        // index defines the index of number "k" in the group;
        int index;
        index = (k-sum/2) +1;

        int halfOfMaxIndex = 0;
        for(int i = 0; i<group ; i++){
            // determine if digit in proper group is 5 or 6
            if ((index) > (halfOfMaxIndex =(int)Math.pow(a1, group-i)/q)){
                sb.append(6);
            } else {
                sb.append(5);
            }

            if ((index = index %halfOfMaxIndex) == 0){
                index = halfOfMaxIndex;
            }
        }
        return sb.toString();
    }
}
