package com.ecommerce.cart_service.controller;

import com.ecommerce.cart_service.model.CartItem;
import com.ecommerce.cart_service.service.CartService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable String userId) {
        return service.getCart(userId);
    }

    @PostMapping("/{userId}")
    public List<CartItem> addItem(@PathVariable String userId, @RequestBody CartItem item) {
        return service.addItem(userId, item);
    }

    @DeleteMapping("/{userId}/{productId}")
    public void removeItem(@PathVariable String userId, @PathVariable Long productId) {
        service.removeItem(userId, productId);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable String userId) {
        service.clearCart(userId);
    }

    @GetMapping("/health")
    public String health() {
        return "Cart service is running!";
    }
}
