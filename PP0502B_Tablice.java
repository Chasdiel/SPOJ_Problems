import java.util.Scanner;

public class PP0502B_Tablice {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t, n;
        t = scanner.nextInt();
        for (int i = 1; i<=t; i++){
            n = scanner. nextInt();
            int[] table = new int[n];

            for (int j=0; j<n ; j++){
                table[j] = scanner.nextInt();
            }

            for(int k = table.length-1; k>=0 ; k--){
                System.out.print(table[k] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}