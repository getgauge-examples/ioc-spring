package com.thoughtworks.gauge.example.java;

import org.springframework.stereotype.Component;

@Component
public class PaypalDebitCardProcessor implements DebitCardProcessor {

    @Override
    public Receipt charge(int amount) {
        if (DebitCard.hasBalance(amount)) {
            DebitCard.debit(amount);
            return new Receipt(ReceiptStatus.SUCCESS, String.format("Successfully charged rupees %d through Paypal!\n", amount));
        }
        return new Receipt(ReceiptStatus.FAILURE, String.format("No balance to charge %d rupees\n", amount));
    }
}
