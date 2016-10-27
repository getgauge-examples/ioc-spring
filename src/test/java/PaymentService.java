import com.thoughtworks.gauge.Step;

import static junit.framework.TestCase.assertEquals;

public class PaymentService {
    private final DebitCardProcessor processor;

    PaymentService(DebitCardProcessor processor) {
        this.processor = processor;
    }

    @Step("Pay amount <rupees> rupees")
    public void payMoney(String amount) {
        int rupees = Integer.parseInt(amount);
        Receipt receipt = this.processor.charge(rupees);

        assertEquals(receipt.getPaymentStatus(), ReceiptStatus.SUCCESS);
    }

    @Step("Fail to pay <100> rupees")
    public void failurePayment(String amount) {
        int rupees = Integer.parseInt(amount);
        Receipt receipt = this.processor.charge(rupees);

        assertEquals(receipt.getPaymentStatus(), ReceiptStatus.FAILURE);
    }
}