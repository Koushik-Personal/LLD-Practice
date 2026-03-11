
public class PaymentProcessor {
    
    Payment payment;
    PaymentProcessor( Payment payment){ 
        this.payment = payment;
    }

    void set( Payment payment) {
        this.payment = payment;
    }

    void pay() {
        payment.send();
    }
}
