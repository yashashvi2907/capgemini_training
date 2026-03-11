package oops;
import java.util.*;

public class practice {
public static void main(String[] args) {
    List<Product> list = new ArrayList<>();

    list.add(new Product(1, "bat", "sports", 400.0));
    list.add(new Product(4, "hairpin", "beauty", 30.0));
    Collections.sort(list);
    System.out.println(list);
}

}

class Item
{
    private String name;
    private String category;

    public Item(String name, String category) {
        this.name = name;
        this.category = category;
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
}

class Product extends Item implements Comparable<Product>
{
    private int id;
    private double price;


    public Product(int id, String name, String category, double price) {
        super(name,category);
        this.id = id;
        setPrice(price);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    @Override
    public int compareTo(Product o) {

        return Double.compare(getPrice(), o.getPrice());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


