package yurilenzi;

import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;
import yurilenzi.catalog.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Supplier<Product> productSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rnd = new Random();
            return new Product(faker.book().title(), faker.book().genre(), rnd.nextInt(10,300));
        };
        List <Product> randomProd = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomProd.add(productSupplier.get());
        }
        //viewProduct(randomProd);
        List<Product> productsOrd = randomProd.stream().sorted(Comparator.comparingDouble(prd -> prd.getPrice())).toList();
        System.out.println("-------------------------------Es3 Prodotti Ordinati per prezzo-------------------------------------------");
        viewProduct(productsOrd);

    }

    public static void viewProduct(List<Product> prd) {
        prd.forEach(product -> {
            System.out.println("Nome: " +product.getName());
            System.out.println("Categoria: " +product.getCategory());
            System.out.println("Prezzo: " + product.getPrice());
            System.out.println("---------------------------");
        });
    }
}
