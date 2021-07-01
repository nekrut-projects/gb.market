package ru.gb.market;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id){
        for (Product p : products) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

}
