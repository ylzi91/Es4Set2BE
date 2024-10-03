package yurilenzi;

import com.github.javafaker.Faker;
import yurilenzi.catalog.Customer;
import yurilenzi.catalog.Order;
import yurilenzi.catalog.Product;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Supplier<Product> productSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rnd = new Random();
            return new Product(faker.book().title(), faker.book().genre(), rnd.nextInt(10,300));
        };
        Supplier<Order> orderSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rnd = new Random();
            return new Order(new Customer(faker.name().name(), rnd.nextInt(1,5)));
        };
        List <Product> randomProd = new ArrayList<>();
        List <Order> randomOrderForCustomer = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomProd.add(productSupplier.get());
        }

        for (int i = 0; i < 4; i++) {
            randomOrderForCustomer.add(orderSupplier.get());
        }
        //viewProduct(randomProd);
        List<Product> productsOrd = randomProd.stream().sorted(Comparator.comparingDouble(prd -> prd.getPrice())).toList();
        System.out.println("-------------------------------Es3 Prodotti Ordinati per prezzo-------------------------------------------");
        viewProduct(productsOrd);
        randomOrderForCustomer.forEach(order -> {
            Random rnd = new Random();
            for (int i = 0; i < rnd.nextInt(1,5); i++) {
                order.addProduct(randomProd.get(rnd.nextInt(0, randomProd.size())));
            }
        });
        System.out.println("-------------------------------Ordini dei clienti-------------------------------------------");
        viewOrderClient(randomOrderForCustomer);
        System.out.println("-------------------------------Esercizio 1-------------------------------------------");
        Map<Customer, List<Order>> orderForClient = randomOrderForCustomer.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        orderForClient.forEach((cst, ord) -> {
            System.out.println("Cliente:" + cst + ", " + ord);
        });
        System.out.println("-------------------------------Esercizio 2-------------------------------------------");
        Map<Customer, Double> aaa = randomOrderForCustomer.stream().collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble(order -> order.getProducts().stream().mapToDouble(prod -> prod.getPrice()).sum())));
        aaa.forEach((cst, total) -> {
            System.out.println("Cliente:" + cst + ", Totale da pagare: " + total);
        });


    }

    public static void viewProduct(List<Product> prd) {
        prd.forEach(product -> {
            System.out.println("Nome: " +product.getName());
            System.out.println("Categoria: " +product.getCategory());
            System.out.println("Prezzo: " + product.getPrice());
            System.out.println("---------------------------");
        });
    }

    public static void viewOrderClient (List<Order> ord){
        ord.forEach(order ->{
            System.out.println("Ordine di " + order.getCustomer().getName());
            System.out.println("Ha oridinato:");
            order.getProducts().forEach(ordPrd -> {
                System.out.println("Nome prodotto: " + ordPrd.getName());
                System.out.println("Prezzo: " +ordPrd.getPrice());
            });
            System.out.println("------------------------------------------------");
        });

    }
}
