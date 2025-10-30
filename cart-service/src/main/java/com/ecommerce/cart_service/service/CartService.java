package com.ecommerce.cart_service.service;


import com.ecommerce.cart_service.model.CartItem;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ValueOperations<String, Object> valueOps;

    public CartService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOps = redisTemplate.opsForValue();
    }

    public List<CartItem> getCart(String userId) {
        Object data = valueOps.get(userId);
        if (data == null) return new ArrayList<>();
        return (List<CartItem>) data;
    }

    public List<CartItem> addItem(String userId, CartItem item) {
        List<CartItem> cart = getCart(userId);
        cart.add(item);
        valueOps.set(userId, cart);
        return cart;
    }

    public void removeItem(String userId, Long productId) {
        List<CartItem> cart = getCart(userId);
        cart.removeIf(item -> Objects.equals(item.getProductId(), productId));
        valueOps.set(userId, cart);
    }

    public void clearCart(String userId) {
        redisTemplate.delete(userId);
    }
}
