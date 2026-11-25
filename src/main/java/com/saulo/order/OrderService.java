package com.saulo.order;

public class OrderService {

    public void create(String orderId) {
        System.out.println("Pedido criado: " + orderId);
    }

    public void cancel(String orderId) {
        System.out.println("Pedido cancelado: " + orderId);
    }
}
