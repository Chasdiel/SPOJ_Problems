import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TOPSES_SezamOpener {  // zadanie TOPSES

    public static Pattern[] patternArr = new Pattern[2];
    public static int strLength;
    public static String subStr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numOfSets = sc.nextInt();
        sc.nextLine();

        String locker1, locker2;

        for(int i = 1; i<=numOfSets; i++) {
            locker1 = sc.nextLine();
            locker2 = sc.nextLine();

            canBeOpened(sb, locker1, locker2);
        }

        System.out.println(sb.toString());
        sc.close();
    }


    public static void canBeOpened(StringBuilder sb, String locker1, String locker2){

        Matcher matchPart1, matchPart2;
        boolean canBeOpened =false;

        createPatterns(locker1);

        matchPart1 = patternArr[0].matcher(locker2);
        matchPart2 = patternArr[1].matcher(locker2);

        if (matchPart1.find()) {
            // compare with part 1:
            canBeOpened = compareTheOtherPart(locker2, matchPart1.start(), matchPart1.end(), patternArr[1]);

            // compare with part 2:
        } else if (matchPart2.find()) {

            canBeOpened = compareTheOtherPart(locker2, matchPart2.start(), matchPart2.end(), patternArr[0]);
        }

        if (canBeOpened) {
            sb.append("yes" + "\n");
        } else {
            sb.append("no"+ "\n");
        }
    }

    public static boolean compareTheOtherPart(String lock, int start, int end, Pattern pattern){
        //determine the other half of string to compare to
        defineSubstr2(lock, start, end);
        // and check if it matches with pattern
        return pattern.matcher(subStr).find();
    }


    public static void createPatterns(String lock1){
        //create pattern for lock1
        strLength = lock1.length();
        String patternL = lock1.substring(0, strLength/2);
        String patternR = lock1.substring(strLength/2, strLength);
        patternArr[0] = Pattern.compile(patternL);
        patternArr[1] = Pattern.compile(patternR);
    }


    public static void defineSubstr2(String lock2, int start, int end) {
        if (start == 0) {
            //if subStr starts from 0 - take only the end part
            subStr = lock2.substring(end, strLength);
        } else {
            // concatenate beginning part of given string with the ending one
            subStr = lock2.substring(end, strLength);
            subStr += lock2.substring(0, start);
        }
    }
}
