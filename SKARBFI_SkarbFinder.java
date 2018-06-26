import java.util.Scanner;

public class SKARBFI_SkarbFinder {
    public static final int NORTH =0;
    public static final int SOUTH =1;
    public static final int WEST =2;
    public static final int EAST =3;

    public static int x, y, direction, steps;

    public static void main(String[] args) {

        int numOfSets, numOfClues;

        Scanner sc = new Scanner(System.in);

//        Enter amount of sets:
        numOfSets = sc.nextInt();

        for (int i = 1; i <= numOfSets; i++) {    //number of sets loop
//            Enter amount and values of clues:
            x = 0;
            y = 0;

            numOfClues = sc.nextInt();

            for (int j = 1; j <= numOfClues; j++) {     //clues loop
                direction = sc.nextInt();
                steps = sc.nextInt();
                CalcShortestPath(direction, steps);
            }
            printPath();
        }
        sc.close();
    }


    public static void CalcShortestPath(int direction, int steps) {
        switch (direction){
            case NORTH:
                y += steps;
                break;
            case SOUTH:
                y -= steps;
                break;
            case WEST:
                x += steps;
                break;
            case EAST:
                x -= steps;
                break;
        }
    }

    //print shortest path
    public static void printPath() {
        if ((y == 0) && (x==0)) {
            System.out.println("studnia");
        }
        // y moves
        if (y < 0) {
            System.out.println(SOUTH + " " + -y);
        } else if (y > 0) {
            System.out.println(NORTH + " " + y);
        }
        // x moves
        if (x < 0) {
            System.out.println(EAST + " " + -x);
        } else if (x > 0){
            System.out.println(WEST + " " + x);
        }
    }
}
