package RequestInheritance;
import java.util.UUID;

/**
 * @see Request
 * */
public class PostRequest extends Request {
    private String ip;
    private static int count;
    PostRequest(UUID randUUID, String randIP){
        super(randUUID);
        ip = randIP;
        count++;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPost request to server with IP address: " + getIp() ;
    }


    /**
     * @return The count of the total PostRequests made
     * */
    public static int count(){
        return count;
    }
}
