package RequestInheritance;

import java.util.UUID;


/**
 * @see PostPaymentRequest
 * */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {
    private String encryptionScheme;
    private static int count;
    PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncrypt){
        super(randUUID, randIP, randPayment);
        encryptionScheme = randEncrypt;
        count++;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThis form was encrypted using: " + encryptionScheme;
    }


    /**
     * @return The count of the total PostEncryptedPaymentRequests made
     * */
    public static int count(){
        return count;
    }
}
