package ru.gb.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.model.Product;
import ru.gb.market.services.CartService;
import ru.gb.market.services.ProductService;

@Controller
public class CartController {
    ProductService productService;
    CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/cart/{id}/add")
    public String addProductInCart(@PathVariable int id){
        Product product = productService.getProductById(id);
        cartService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping(value = "/cart")
    public String showCart(Model model){
        model.addAttribute("contentsCart", cartService.getContentsCart());
        return "cart";
    }

    @GetMapping(value = "/cart/{id}/del")
    public String deleteProduct(Model model, @PathVariable int id){
        cartService.deleteProductById(id);
        return "redirect:/cart";
    }
}
