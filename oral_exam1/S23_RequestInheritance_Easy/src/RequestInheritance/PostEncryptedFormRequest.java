package RequestInheritance;

import java.util.UUID;


/**
 * @see PostFormRequest
 * */
public class PostEncryptedFormRequest extends PostFormRequest {
    private String encryptScheme;
    private static int count;
    PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptScheme){
        super(randUUID, randIP, randForm);
        encryptScheme = randEncryptScheme;
        count++;
    }

    public String getEncryptScheme() {
        return encryptScheme;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThis form was encrypted using: " + getEncryptScheme();
    }


    /**
     * @return The count of the total PostEncryptedFormRequests made
     * */
    public static int count(){
        return count;
    }
}
