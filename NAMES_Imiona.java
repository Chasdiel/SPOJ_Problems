import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class NAMES_Imiona {

    public static List<Map.Entry<String, Integer>> sortTreeMapByIntegerValue(TreeMap temp){

        Set<Map.Entry<String, Integer>> entryOfMap = temp.entrySet();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(entryOfMap);

        Collections.sort(entries, (Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) -> m2.getValue().compareTo(m1.getValue()));
        return entries;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> names = new TreeMap<>();
        String info;
        String name;
        while (!(info = br.readLine()).isEmpty()){
            try{

                /* wersja zrobiona tylko do Testów na SPOJ - inaczej nie przechodzi testów - NZEC (non-zero exit code), choć wszystko działa dobrze:
        while (sc.hasNext()) {
            info = sc.nextLine();
         */
                name = info.split(" ")[2].toUpperCase();

                if (names.containsKey(name)) {
                    names.replace(name, names.get(name) + 1);
                } else {
                    names.put(name, 1);
                }
            }catch(Exception e){
                return;
            }
        }

        br.close();

        for(Map.Entry<String, Integer> entry : sortTreeMapByIntegerValue(names)){
            sb.append(entry.getKey());
            sb.append(" ");
            sb.append(entry.getValue());
            sb.append("\n");
        };
        System.out.print(sb.toString().trim());
    }
}