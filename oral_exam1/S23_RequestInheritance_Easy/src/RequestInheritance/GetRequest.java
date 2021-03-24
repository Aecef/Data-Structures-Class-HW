package RequestInheritance;
import java.util.UUID;

/**
 * @see Request
 * */
public class GetRequest extends Request {
    private String url;
    private static int countGR;
    GetRequest(UUID randUUID, String randURL){
        super(randUUID);
        url = randURL;
        countGR++;
    }
    GetRequest(UUID randUUID){
        super(randUUID);
        countGR++;
    }

    public String getUrl() {
        return url;
    }


    /**
     * @return The count of the total GetRequests made
     * */
    public static int count(){
        return countGR;
    }
}
