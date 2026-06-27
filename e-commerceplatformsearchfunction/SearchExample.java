import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + "  " + productName + "  " + category);
    }
}

public class SearchExample {

    static Product linearSearch(Product[] products, int id) {

        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }

        return null;
    }

    static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return products[mid];

            if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Keyboard", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories")
        };

        int searchId = 104;

        System.out.println("Linear Search");

        Product result1 = linearSearch(products, searchId);

        if (result1 != null)
            result1.display();
        else
            System.out.println("Product Not Found");
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search");

        Product result2 = binarySearch(products, searchId);

        if (result2 != null)
            result2.display();
        else
            System.out.println("Product Not Found");
    }
}