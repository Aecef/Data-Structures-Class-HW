package RequestInheritance;

import java.util.UUID;



/**
 * @see PostRequest
 * */
public class PostPaymentRequest extends PostRequest {
    private Payment payment;
    private static int count;
    PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment){
        super(randUUID, randIP);
        payment = randPayment;
        count++;

    }

    @Override
    public String toString() {
        return super.toString() + "\nPayment Data" + "\nPayment Sender: " + payment.getNameF() +
                "\nPayment Amount: $" + payment.getPaymentTotal() + "\nPayment Receiver: " + payment.getNameS();
    }


    /**
     * @return The count of the total PostPaymentRequests made
     * */
    public static int count(){
        return count;
    }
}
