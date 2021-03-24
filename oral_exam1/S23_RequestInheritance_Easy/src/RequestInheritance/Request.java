package RequestInheritance;
import java.util.UUID;


/**
 * @see DataGenerator
 * */
public class Request extends DataGenerator {
    private UUID uuid;
    private static int count;
    Request(UUID randUUID){
        uuid = randUUID;
        count++;
    }


    @Override
    public String toString(){
        return super.toString() + "\nUUID: " + uuid.toString();
    }

    public UUID getUuid() {
        return uuid;
    }
    /**
     * @return The count of the total Requests made
     * */
    public static int count() {
        return count;
    }
}
