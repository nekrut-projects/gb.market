package ru.gb.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainConfig {
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/add_form")
    public String getAddForm(){
        return "add_form";
    }
    @PostMapping(value = "/add")
    public String addProduct(@RequestParam int id, @RequestParam String title, @RequestParam float price){
        Product product = new Product(id, title, price);
        productRepository.addProduct(product);
        return "redirect:/add_form";
    }

    @GetMapping(value = "products")
    public String getMainPage(Model model){
        model.addAttribute("products", productRepository.getProducts());
        return "products";
    }
}
