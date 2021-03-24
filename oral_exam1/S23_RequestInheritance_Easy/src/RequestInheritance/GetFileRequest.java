package RequestInheritance;

import java.util.UUID;
/**
 * @see GetRequest
 * */
public class GetFileRequest extends GetRequest{
    private File file;
    private static int count;
    GetFileRequest(UUID randUUID, File randFile){
        super(randUUID,"file:///Users/cie_student/question.txt");
        file = randFile;
        count++;
    }

    @Override
    public String toString(){
        return super.toString() + "\nUniversal Resource Locator (URL): " + getUrl() + "\nFile Path: " +file.getFilePath()  +
                "\nFile Type: " + file.getFileType();
    }

    /**
     * @return The count of the total GetFileRequests made
     * */
    public static int count(){
        return count;
    }
}
