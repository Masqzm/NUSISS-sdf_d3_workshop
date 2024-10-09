package csv;

public class App {
    private String name;
    private String category;
    private float rating;

    public App(String name, String category, String rating) {
        this.name = name;
        this.category = category;
        this.rating = Float.parseFloat(rating);
    }
    public App(String name, String category, Float rating) {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return  "Name: " + this.name + 
                " | Category: " + this.category +
                " | Rating: ";
    }
}
