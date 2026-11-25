package com.saulo.payment;

import java.math.BigDecimal;

public class PaymentService {

    private final boolean shouldFail;

    public PaymentService(boolean shouldFail) {
        this.shouldFail = shouldFail;
    }

    public void process(String orderId, BigDecimal amount) {
        System.out.println("Processando pagamento...");

        if (shouldFail) {
            throw new IllegalStateException("Pagamento recusado!");
        }

        System.out.println("Pagamento aprovado: R$ " + amount);
    }

    public void refund(String orderId, BigDecimal amount) {
        System.out.println("Pagamento estornado: R$ " + amount);
    }
}
