import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class DebitCard {

    static final int MAX_AMOUNT = 10000;
    private static int balance = MAX_AMOUNT;

    @Step("Set debit card balance as <amount> rupees")
    public void setLimit(String amount) {
        try {
            balance = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            Assert.fail(String.format("Failed to parse the amount %s", amount));
        }
    }

    public static boolean hasBalance(int amount) {
        return amount <= balance;
    }

    public static void debit(int amount) {
        balance -= amount;
    }
}
