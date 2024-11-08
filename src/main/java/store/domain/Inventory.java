package store.domain;

import static store.view.Constant.BLANK;
import static store.view.Constant.PRODUCTS_FILE_NAME;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    List<Product> products;

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

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
