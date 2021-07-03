package ru.gb.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void addProduct(String title, float price) {
        productRepository.addProduct(title, price);
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
