package yurilenzi.catalog;

public class Customer {
    private static long id = 2000;
    private String name;
    protected int tier;

    public Customer(String name, int tier) {
        this.name = name;
        this.tier = tier;
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public static long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
