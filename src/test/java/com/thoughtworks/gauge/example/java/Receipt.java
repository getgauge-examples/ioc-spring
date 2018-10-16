package com.thoughtworks.gauge.example.java;

public class Receipt {

    private String message;
    private ReceiptStatus paymentStatus;


    public Receipt(ReceiptStatus status, String message) {
        this.paymentStatus = status;
        this.message = message;
    }

    public ReceiptStatus getPaymentStatus() {
        return this.paymentStatus;
    }
}
