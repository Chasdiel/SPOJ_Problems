import java.util.Scanner;

public class FANGEN_Wiatraczki {
    public static char[][] fan;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int fanSize;

//        System.out.println("Rozmiar wiatraka wynosi 2*n. Podaj n:");

        while ((fanSize = sc.nextInt()) != 0) {
                genFan(fanSize, fanSize > 0);
            drawFan();
        }
    }


    public static void genScaffold(int n){
        genArray(n);
        char sign = '*';
        for(int i=0; i<n;i++){
            fan[i][i] = sign;
            fan[i][n*2-1-i] = sign;
            fan[n*2-1-i][i] = sign;
            fan[n*2-1-i][n*2-1-i] = sign;
        }
    }


    public static void genArray(int n) {
        fan = new char[2*n][2*n];
    }


    public static void drawFan() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : fan) {
            for (char column : row) {
                sb.append(column);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void genFan(int n, boolean isClockwise){
        n = Math.abs(n);
        genScaffold(n);
        int j,ring;

        char sign1 = isClockwise ? '.' : '*';
        char sign2 = isClockwise ? '*' : '.';

        for (ring=0; ring<n-1 ;ring++) {
            for (j = 1+ring; j < n * 2 - ring - 1; j++) {
                if (j < n) {
                    fan[ring][j] = sign1;
                    fan[fan.length - ring - 1][j] = sign2;
                    fan[j][ring] = sign2;
                    fan[j][fan.length - ring - 1] = sign1;
                } else {
                    fan[ring][j] = sign2;
                    fan[fan.length - ring - 1][j] = sign1;
                    fan[j][ring] = sign1;
                    fan[j][fan.length - ring - 1] = sign2;
                }
            }
        }
    }
}