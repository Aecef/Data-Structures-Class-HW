package RequestInheritance;
import java.util.UUID;


/**
 * @see PostRequest
 * */
public class PostFormRequest extends PostRequest {
    private Form form;
    private static int count;
    PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        super(randUUID, randIP);
        form = randForm;
        count++;
    }

    @Override
    public String toString() {

        String holder = "";
        for(String s : this.form.fields.keySet())
            holder += "\nLabel: " + s + "\nValue: " + this.form.fields.get(s);
        return super.toString() + holder;
    }

    /**
     * @return The count of the total PostFormRequests made
     * */
    public static int count(){
        return count;
    }
}
