public class SearchAlgorithms {
    public static Product linearSearch(Product[] products, int targetId) {
        int i = 0;
        while (i < products.length) {
            if (products[i].getProductId() == targetId) {
                return products[i];
            }
            i++;
        }
        return null;
    }
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;
        do {
            int mid = left + (right - left) / 2;
            int midId = sortedProducts[mid].getProductId();
            if (midId == targetId) {
                return sortedProducts[mid];
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);
        return null;
    }
}
