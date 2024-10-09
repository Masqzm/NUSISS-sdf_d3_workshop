package csv;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    // Fn. to parse csv entries col by col, char by char; Returns string list of col entries
    public static List<String> parse(String row) {
        List<String> colEntries = new ArrayList<>();    // to hold each col entries of a row
        boolean isInQuotes = false;                     // to check whether entry is in quotes (due to entry having commas in them)
        StringBuilder sbCurrentEntry = new StringBuilder();      // use SB for more efficient string mutations (as it doesn't create new String objects)

        // Loop thru each ch in a row
        for (char ch : row.toCharArray()) {
            if (ch == '\"') 
            {
                // (if alrd in quotes, this means ch is at the end quote now)
                isInQuotes = !isInQuotes;
            } 
            else if (!isInQuotes && ch == ',')  
            {
                colEntries.add(sbCurrentEntry.toString().trim());
                sbCurrentEntry.setLength(0);    // reset sb
            } 
            else 
            {
                // entry can be either within quotes or not (have yet to meet comma in latter case)
                sbCurrentEntry.append(ch);
            }
        }

        // Add the last entry as there is no comma at the end of row
        colEntries.add(sbCurrentEntry.toString().trim()); 

        return colEntries;
    }
}
