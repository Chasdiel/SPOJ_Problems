import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.lang.*;

public class PRIME_T_LiczbyPierwsze {

//    public static HashMap<Integer, Character> primeList = new HashMap<>();
    public static HashSet<Integer> primeList = new HashSet<>();

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n, number;

        makeListOfPrimeTo10000();

        n = scanner.nextInt();

        for (int i = 1; i<=n; i++){
            number = scanner.nextInt();
            if(isInPrimeList(number)){
                sb.append("TAK" + "\n");
            } else{
                sb.append("NIE" + "\n");
            }
        }
        System.out.println(sb.toString());

        scanner.close();
    }


    public static void makeListOfPrimeTo10000(){
        for (int i= 1; i<=10000; i++){
            if(isPrime(i)) primeList.add(i);          // dla hashSet lub ArrayList
//            if(isPrime(i)) primeList.put(i, '0');        //dla hashMap
        }
    }


    public static boolean isInPrimeList(int number){
        return primeList.contains(number);        // dla hashSet lub ArrayList
//        return primeList.containsKey(number);      //dla hashMap
    }


    public static boolean isPrime(int number) {
        if(number==1) {
            return false;
        }
        if(number==2) {
            return true;
        }

        if(number%2==0) {
            return false;
        }
        for(int i=3; i*i<=number; i+=2) {
            if(number%i==0) {
                return false;
            }
        }
        return true;
    }
}

/* wg SPOJ rozwiązanie poniżej trwa 0.74s, a powyżej 0.71s - dopiero StringBuilder dał czas 0.43s dla HashSet i 0.44s dla HashMap
        if(number==1) {
            return false;
        }
        if(number==2) {
            return true;
        }
        if(number%2==0) {
            return false;
        }
        for(int i=3; i*i<=number; i+=2) {
            if(number%i==0) {
                return false;
            }
        }

        return true;
    }
 */

/*
Dla 100:

HashSet:
dla 100:
39220000, 37980000, 38100000, 39090000

ArrayList:
47430000, 45610000, 43510000, 45490000

HashMap:
(z Character)
37200000, 38910000, 36880000, 38120000
(z Boolean)
39220000, 39370000, 37290000, 37820000

Przy użyciu StringBuildera:
~620000 przy każdej strukturze danych
 */