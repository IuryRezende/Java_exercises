package Service;

public class PayPalService implements OnlinePaymentService {

    public double paymentFee(double amount){
        return amount + (amount * 0.02);
    }

    public double interest(double amount, int month){
        double interest = amount + amount * (0.01 * (double)month);

        return paymentFee(interest);
    }
}
