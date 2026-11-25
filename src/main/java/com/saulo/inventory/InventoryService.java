package com.saulo.inventory;

public class InventoryService {

    public void reserve(String productId, int quantity) {
        System.out.println(
                "Estoque reservado: " + quantity + " unidade(s) do produto " + productId
        );
    }

    public void release(String productId, int quantity) {
        System.out.println(
                "Estoque liberado: " + quantity + " unidade(s) do produto " + productId
        );
    }
}
