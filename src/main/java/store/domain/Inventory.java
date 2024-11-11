package store.domain;

import static store.util.Constant.BLANK;
import static store.util.Constant.PRODUCTS_FILE_NAME;
import static store.util.ErrorMessage.INSUFFICIENT_INVENTORY_MESSAGE;
import static store.util.ErrorMessage.PRODUCT_NOT_FOUND_MESSAGE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Inventory {

    static List<Product> products;

    public Inventory() throws IOException {
        this.products = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(PRODUCTS_FILE_NAME));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            List<Object> productInfo = parseProductInfo(line);
            addIfNoProductWithoutPromotion(productInfo);
            products.add(createProduct(productInfo));
        }
        br.close();
    }

    public void reducePromotionStock(String productName, int quantity) {
        Product product = findProductWithPromotion(productName);
        int subtractValue = product.getQuantity() - quantity;
        if (subtractValue < 0) {
            product.reduceQuantityToZero();
            Product productWithoutPromotion = findProductWithoutPromotion(productName);
            reduceProduct(productWithoutPromotion, -1 * subtractValue);
            return;
        }
        reduceProduct(product, quantity);
    }

    public void reduceNotPromotionStock(String productName, int quantity) {
        Product product = findProductWithoutPromotion(productName);
        int subtractValue = product.getQuantity() - quantity;
        if (subtractValue < 0) {
            product.reduceQuantityToZero();
            Product productWithPromotion = findProductWithPromotion(productName);
            reduceProduct(productWithPromotion, -1 * subtractValue);
            return;
        }
        reduceProduct(product, quantity);
    }

    private void reduceProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            product.reduceQuantity();
        }
    }

    public void checkOrder(Order order) {
        Map<String, Integer> orderInfo = order.getOrders();
        orderInfo.forEach((name, quantity) -> {
            if (!hasProduct(name)) {
                throw new IllegalArgumentException(PRODUCT_NOT_FOUND_MESSAGE);
            }
            if (isQuantityExceedingInventory(name, quantity)) {
                throw new IllegalArgumentException(INSUFFICIENT_INVENTORY_MESSAGE);
            }
        });
    }

    private List<Object> parseProductInfo(String line) {
        List<Object> productInfo = new ArrayList<>(List.of(line.split(",")));
        String productPrice = (String) productInfo.get(1);
        productInfo.set(1, Integer.parseInt(productPrice));
        String productQuantity = (String) productInfo.get(2);
        productInfo.set(2, Integer.parseInt(productQuantity));
        return productInfo;
    }

    private void addIfNoProductWithoutPromotion(List<Object> productInfo) {
        if (!products.isEmpty()) {
            Product lastAddProduct = products.getLast();
            if (hasNoProductWithoutPromotion(lastAddProduct, productInfo)) {
                products.add(createProductWithoutPromotion(lastAddProduct));
            }
        }
    }

    private boolean hasNoProductWithoutPromotion(Product lastAddProduct, List<Object> productInfo) {
        String addProductName = (String) productInfo.getFirst();
        if (!lastAddProduct.getName().equals(addProductName)) {
            return lastAddProduct.hasPromotion();
        }
        return false;
    }

    private Product createProductWithoutPromotion(Product lastAddProduct) {
        return new Product(lastAddProduct.getName(), lastAddProduct.getPrice(), 0, BLANK);
    }

    private Product createProduct(List<Object> productInfo) {
        String name = (String) productInfo.getFirst();
        int price = (int) productInfo.get(1);
        int quantity = (int) productInfo.get(2);
        String promotion = (String) productInfo.getLast();
        return new Product(name, price, quantity, promotion);
    }

    private boolean hasProduct(String name) {
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public Product findProductWithPromotion(String name) {
        for (Product product : products) {
            if (name.equals(product.getName()) && product.hasPromotion()) {
                return product;
            }
        }
        return null;
    }

    public Product findProductWithoutPromotion(String name) {
        for (Product product : products) {
            if (name.equals(product.getName()) && !product.hasPromotion()) {
                return product;
            }
        }
        return null;
    }

    private boolean isQuantityExceedingInventory(String name, int quantity) {
        int totalQuantity = findTotalQuantity(name);
        return totalQuantity < quantity;
    }

    private int findTotalQuantity(String name) {
        int totalQuantity = 0;
        for (Product product : products) {
            if (name.equals(product.getName())) {
                totalQuantity += product.getQuantity();
            }
        }
        return totalQuantity;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
