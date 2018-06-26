import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VSR_PredkoscSrednia {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int v1, v2, Vavg, numOfSets;
        String[] numTab;

        numOfSets = Integer.parseInt(br.readLine());

        for (int i = 0; i<numOfSets; i++){
            numTab = br.readLine().split(" ");
            v1 = Integer.parseInt(numTab[0]);
            v2 = Integer.parseInt(numTab[1]);
            Vavg = 2*v1*v2 / (v1+v2);
            sb.append(Vavg+"\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}
