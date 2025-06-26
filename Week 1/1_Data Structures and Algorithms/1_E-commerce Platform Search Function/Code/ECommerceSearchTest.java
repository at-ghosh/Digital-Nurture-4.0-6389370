import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(203, "Smartphone", "Electronics"),
                new Product(305, "Desk Chair", "Furniture"),
                new Product(412, "Coffee Maker", "Appliances"),
                new Product(520, "Headphones", "Electronics")
        };

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        String[] searchTypes = {"Linear", "Binary"};
        for (String type : searchTypes) {
            System.out.println("==== " + type + " Search ====");
            long startTime = System.nanoTime();
            Product found = null;
            if (type.equals("Linear")) {
                found = SearchAlgorithms.linearSearch(products, 305);
            } else {
                found = SearchAlgorithms.binarySearch(sortedProducts, 305);
            }
            long endTime = System.nanoTime();
            System.out.printf("Result: %s\nTime taken: %,d ns\n", found, (endTime - startTime));
        }

        System.out.println("\n-- Performance Comparison --");
        int[] sizes = {1000, 10000, 100000};
        for (int size : sizes) {
            compareSearchPerformance(size);
        }
    }

    private static void compareSearchPerformance(int size) {
        Product[] largeProducts = new Product[size];
        for (int i = 0; i < size; i++) {
            largeProducts[i] = new Product(i, "Product " + i, "Category " + (i % 10));
        }
        Product[] sortedLargeProducts = Arrays.copyOf(largeProducts, largeProducts.length);
        Arrays.sort(sortedLargeProducts, Comparator.comparingInt(Product::getProductId));
        int targetId = size / 2;
        System.out.printf("\nSize: %,d\n", size);
        long start = System.nanoTime();
        SearchAlgorithms.linearSearch(largeProducts, targetId);
        long end = System.nanoTime();
        System.out.printf("  Linear: %,d ns\n", (end - start));
        start = System.nanoTime();
        SearchAlgorithms.binarySearch(sortedLargeProducts, targetId);
        end = System.nanoTime();
        System.out.printf("  Binary: %,d ns\n", (end - start));
    }
}
