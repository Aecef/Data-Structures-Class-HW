package RequestInheritance;

import java.util.UUID;


/**
 * @see GetRequest
 * */
public class GetVideoRequest extends GetRequest {
    private Video video;
    private static int count;
    GetVideoRequest(UUID randUUID, Video randVid){
        super(randUUID);
        video = randVid;
        count++;
    }


    @Override
    public String toString(){
        return (super.toString() + "\nUniversal Resource Locator (URL): " + video.getUrl() + "\nVideo: " + video.getVideoTitle() +
        "\nBy: " + video.getName());
    }


    /**
     * @return The count of the total GetVideoRequests made
     * */
    public static int count(){
        return count;
    }
}
