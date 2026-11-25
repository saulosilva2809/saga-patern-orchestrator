package com.saulo.shipping;

public class ShippingService {

    public void request(String orderId) {
        System.out.println("Envio solicitado para o pedido: " + orderId);
    }

    public void cancel(String orderId) {
        System.out.println("Solicitação de envio cancelada: " + orderId);
    }
}
