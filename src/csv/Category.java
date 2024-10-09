package csv;

import java.util.ArrayList;
import java.util.List;

// Class to store apps of same category
public class Category {
    private String name;
    private App highestRatedApp;    // in case of tie it uses the first highest rated app found
    private App lowestRatedApp;     // in case of tie it uses the first lowest rated app found

    public List<App> apps = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Boolean addApp(App newApp) {
        if(Float.isNaN(newApp.getRating()))     // if app has NaN rating,
            return false;                       // ignore the app (do not add)

        apps.add(newApp);

        return true;
    }

    public String getName() { return this.name; }

    public App getHighestRatedApp() { 
        if(apps.isEmpty())
            return null;

        if(this.highestRatedApp == null)
        {
            float highestRating = 0;

            for (App app : apps) {
                // If current app being considered has higher rating
                if(app.getRating() > highestRating) {
                    highestRating = app.getRating();    // update highestRating value
                    this.highestRatedApp = app;         // update highestRating app
                }
            }       
        }

        return this.highestRatedApp; 
    }

    public App getLowestRatedApp() { 
        if(apps.isEmpty())
            return null;

        if(this.lowestRatedApp == null)
        {
            // Initiate first app as baseline for lowest rating
            float lowestRating = apps.get(0).getRating();   
            this.lowestRatedApp = apps.get(0);

            for (App app : apps) {
                // If current app being considered has lower rating
                if(app.getRating() < lowestRating) {
                    lowestRating = app.getRating();    // update lowestRating value
                    this.lowestRatedApp = app;         // update lowestRating app
                }
            }       
        }

        return this.lowestRatedApp; 
    }

    public float getAvgRating() {
        if(apps.size() > 0) {
            float totalRatings = 0;
            
            for(App app : apps) 
                totalRatings += app.getRating();

            return (float) (totalRatings / apps.size());
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return  this.apps.size() + " (apps with valid ratings)";
    }
}
