package com.ecommerce.cart_service.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private Long productId;
    private String name;
    private int quantity;
    private double price;
}