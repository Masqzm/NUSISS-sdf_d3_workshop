package d3.io;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

// Count total unique words using Map
public class CountWordsMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String inFile = args[0];        

        // Open input file for reading
        Reader reader = new FileReader(inFile);
        BufferedReader br = new BufferedReader(reader);

        // Create map
        Map<String, Integer> uniqueWords = new HashMap<>();
        
        String line;    // to store current line being read
        
        while((line = br.readLine()) != null)       // read line if it exists in input file
        {
            if(line.isEmpty())
                continue;

            // Process line
            String regex = "\\p{Punct}"; // matches any char in: !”#$%&'()*+,-./:;<=>?@[\]^_`{|}~:
            String processed = line.replaceAll(regex, "").toLowerCase().trim();
            
            //System.out.printf("START:");
            // Go thru each word in line
            for(String word : processed.split(" "))
            {
                int currentCount = 1;

                // Check if map has current word, update currentCount if avail
                if (uniqueWords.containsKey(word))
                    currentCount = uniqueWords.get(word) + 1;

                // Put word in map with updated/inialised currentCount
                uniqueWords.put(word, currentCount);

                //System.out.printf("%s,", word);
            }
            //System.out.printf("END\n");
            //System.out.printf("VS|%s|\n\n", line);
        }

        // Close files
        reader.close();

        System.out.println();
        // Print the keys set in alphabetical order
        for (String word : uniqueWords.keySet())
            System.out.printf("[%s]\t\t\t %d\n", word, uniqueWords.get(word));

        System.out.printf("Total unique words in %s: %d\n\n", inFile, uniqueWords.keySet().size());
    }
}


// TO DO:
// 1. Remove stop words
// 2. Print the list of unique words in alphabetical order