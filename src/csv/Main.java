package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Program that processes csv file to display the following for every category:
// 1. Category name
// 2. Highest rated app name and rating
// 3. Lowest rated app name and rating
// 4. Average rating for the category   -> NaN ratings resolution: exclude that app
// Remember to add txt file when running progam! 
// (e.g. java -cp classes csv.Main googleplaystore.csv)
public class Main {
    // Constants
    public static final int COL_APPNAME = 0;  
    public static final int COL_APPCATEGORY = 1;
    public static final int COL_APPRATING = 2;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // if(args.length <= 0) {
        //     System.err.println("File name not provided, program will now close!");
        //     System.exit(1); // exit code 0 = all good
        // }

        //String inFile = args[0];        
        String inFile = "googleplaystore.csv";

        // Open input file for reading
        Reader reader = new FileReader(inFile);
        BufferedReader br = new BufferedReader(reader);

        String headers;     // to store csv headers
        String line;        // to store current line being read 
        Map<String, Category> appStore = new HashMap<>();       // Key: Category name (String) | Value: appCategories (Category - list of apps)

        headers = br.readLine();   

        while((line = br.readLine()) != null)       // read line if it exists in input file
        {   
            if(line.isEmpty())  // skip any blank entry
                continue;

            
            // Convert and store line into list of string 
            List<String> row = CSVParser.parse(line);

            // Debugging
            // System.out.println("FROM ROW: " + row.get(COL_APPNAME) + " | " + row.get(COL_APPCATEGORY) + " | " + row.get(COL_APPRATING));

            // Store app values
            App app = new App(row.get(COL_APPNAME), row.get(COL_APPCATEGORY), row.get(COL_APPRATING));

            // Debugging
            // System.out.println("NEW APP OBJ: " + app);

            // if category alrd exist, 
            if(appStore.containsKey(row.get(COL_APPCATEGORY)))
            {
                // add app into that category
                appStore.get(row.get(COL_APPCATEGORY)).addApp(app);
            }
            else 
            {
                // add new category along with the app
                Category appCategory = new Category(row.get(COL_APPCATEGORY));

                appStore.put(row.get(COL_APPCATEGORY), appCategory);
            }

        }

        // Close files
        reader.close();


        // Print out each category size
        for (String key : appStore.keySet()) {
            Category appCategory = appStore.get(key);

            // Print out each category size
            System.out.println("CATEGORY NAME: " + key + " | TOTAL APPS: " + appCategory);

            // If no apps with valid ratings exist in this category
            if(appCategory.apps.size() == 0)
            {
                System.out.println( "NO APPS WITH VALID RATINGS EXIST IN THIS CATEGORY!!"); 
            }
            else
            {
                // Print out each category highest rated app name and rating
                System.out.println( "HIGHEST RATED APP: " + appStore.get(key).getHighestRatedApp().getName() + 
                                    " | APP RATING: " + appStore.get(key).getHighestRatedApp().getRating());

                // Print out each category lowest rated app name and rating
                System.out.println( "LOWEST RATED APP: " + appStore.get(key).getLowestRatedApp().getName() + 
                                    " | APP RATING: " + appStore.get(key).getLowestRatedApp().getRating());

                // Print out each category avg rating
                System.out.println( "AVERAGE APP RATING: " + appStore.get(key).getAvgRating());
            }

            System.out.println();
        }
    }
}

// note if rating is NaN ignore the app (do not include)