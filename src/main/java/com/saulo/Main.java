package com.saulo;

import com.saulo.inventory.InventoryService;
import com.saulo.orchestrator.SagaOrchestrator;
import com.saulo.order.OrderService;
import com.saulo.payment.PaymentService;
import com.saulo.shipping.ShippingService;

import java.math.BigDecimal;

public class Main {

    static void main() {

        OrderService orderService = new OrderService();
        InventoryService inventoryService = new InventoryService();

        // true -> falha no pagamento
        PaymentService paymentService = new PaymentService(true);

        ShippingService shippingService = new ShippingService();

        SagaOrchestrator orchestrator = new SagaOrchestrator(
                orderService,
                inventoryService,
                paymentService,
                shippingService
        );

        orchestrator.executePurchase(
                "ORDER-001",
                "PRODUCT-001",
                2,
                new BigDecimal("199.90")
        );
    }
}
