import java.util.*;
import java.io.File;
import java.io.IOException;

public class JavaIdentifierCount {
    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new File("Identifier.java"));
        /*Map<Integer, ArrayList<String>> map = new TreeMap<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> wordsRepeat = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();*/

        Map<String, Set<Integer>> index= new HashMap<>();

        int lineNumber = 1;
        while(fin.hasNextLine()) {
            String s = fin.nextLine();
            Scanner in = new Scanner(s);
            in.useDelimiter("[^A-Za-z0-9_]+");
            while (in.hasNext()) {
                String ident = in.next();
                if(!index.containsKey(ident))
                {
                    Set<Integer> lineSet = new HashSet<>();
                    lineSet.add(lineNumber);
                    index.put(ident, lineSet);
                }
                else {
                    index.get(ident).add(lineNumber);
                }
                //words.add(in.next());
                //nums.add(count);
            }
            lineNumber++;
        }
        System.out.println(index);
        for(String k: index.keySet())
        {
            System.out.println(k +" - " + index.get(k));
        }
/*
        int count = 0;
        Scanner in2 = new Scanner(new File("Identifier.java"));
        while (in2.hasNextLine()) {
            String line = in2.nextLine();
            lines.add(line);
            String[] lineSplit = line.split("[^A-Za-z0-9_]+");

            for (int i = 0; i < lineSplit.length; i++) {
                wordsRepeat.add(lineSplit[i]);
                nums.add(count);
            }

            count++;
        }

        for (int i = 0; i < lines.size(); i++) {
            ArrayList<String> lineWords = new ArrayList<>();

            for (int j = 0; j < nums.size(); j++) {
                if (i == nums.get(j)) {
                    lineWords.add(wordsRepeat.get(j));
                }
            }

            map.put(i+1, lineWords);
        }
*/
        /*while (in.hasNext()) {
            //String[] words = in.nextLine().split("[^A-Za-z0-9_]+");
            words.add(in.next());
            nums.add(count);

            if (in.) {

            }

            /*for (int i = 0; i < words.length; i++) {
                map.put(words[i], count);
            }*/
            //map.put(in.next(), count);
            //if (!map.containsKey(in.next())) map.put(in.next(), new ArrayList<Integer>());
            //else map.put(in.next());
            //count++;
        //}*/

        //in.reset(); //resetting doesn't fix this for some reason
        /*Scanner in2 = new Scanner(new File("Identifier.java"));
        int count = 1;
        while (in2.hasNextLine()) {
            String line = in2.nextLine();
            //String[] dennisplit = dennis.split(" ");
            //System.out.println(dennis);

            for (int i = 0; i < words.size(); i++) {
                //System.out.println(dennis);
                if (line.contains(words.get(i))) {
                    //System.out.println("HI");
                    nums.add(count);
                    wordsRepeat.add(words.get(i));
                }
            }

            lines.add(line);
            count++;
        }*/

        /*for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
            for (int j = 0; i < nums.size(); i++) {
                if (words.contains(wordsRepeat.get(i))) {
                    System.out.println(lines.get(nums.get(i)));
                }
            }
        }*/

        /*System.out.println(words);
        System.out.println(nums);
        System.out.println(wordsRepeat);
        System.out.println(lines);
        System.out.println("\n----------Map-------------");
        System.out.println(map);*/

        /*for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
            System.out.println("----------");
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j+1).contains(words.get(i))) {
                    System.out.println(j+1 + ": " + lines.get(j));
                }
            }
            System.out.println();
        }*/
    }
}
