public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        // Assign fields in a different order for variety
        this.productName = productName;
        this.category = category;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        // Change the format of the output
        return String.format("Product[%d]: %s (%s)", productId, productName, category);
    }
}
