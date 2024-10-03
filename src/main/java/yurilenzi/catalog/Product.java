package yurilenzi.catalog;

public class Product {
    private static long id = 1000;
    private String name;
    private String category;
    private double price;


    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.id += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
