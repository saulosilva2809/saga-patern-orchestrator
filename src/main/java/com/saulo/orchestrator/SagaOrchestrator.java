package com.saulo.orchestrator;

import com.saulo.inventory.InventoryService;
import com.saulo.order.OrderService;
import com.saulo.payment.PaymentService;
import com.saulo.shipping.ShippingService;

import java.math.BigDecimal;

public class SagaOrchestrator {

    private final OrderService orderService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    public SagaOrchestrator(OrderService orderService, InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
    }

    private void compensate(
            String orderId,
            String productId,
            int quantity,
            BigDecimal amount,
            boolean orderCreated,
            boolean inventoryReserved,
            boolean paymentProcessed,
            boolean shippingRequested
    ) {
        System.out.println("Iniciando compensações...");

        if (shippingRequested) {
            shippingService.cancel(orderId);
        }

        if (paymentProcessed) {
            paymentService.refund(orderId, amount);
        }

        if (inventoryReserved) {
            inventoryService.release(productId, quantity);
        }

        if (orderCreated) {
            orderService.cancel(orderId);
        }

        System.out.println("Processo de compensação finalizado.");
    }

    public void executePurchase(
            String orderId,
            String productId,
            int quantity,
            BigDecimal amount
    ) {
        boolean orderCreated = false;
        boolean inventoryReserved = false;
        boolean paymentProcessed = false;
        boolean shippingRequested = false;

        try {
            // criar pedido
            orderService.create(orderId);
            orderCreated = true;

            // reservar estoque
            inventoryService.reserve(productId, quantity);
            inventoryReserved = true;

            // processar pagamento
            paymentService.process(orderId, amount);
            paymentProcessed = true;

            // solicitar envio
            shippingService.request(orderId);
            shippingRequested = true;

            System.out.println("Compra concluída com sucesso!");

        } catch (Exception e) {
            System.out.println("Falha na saga: " + e.getMessage());

            compensate(
                    orderId,
                    productId,
                    quantity,
                    amount,
                    orderCreated,
                    inventoryReserved,
                    paymentProcessed,
                    shippingRequested
            );
        }
    }
}
