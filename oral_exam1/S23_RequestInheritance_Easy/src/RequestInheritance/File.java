package RequestInheritance;

public class File {
    private String filePath, fileType;
    File(String filePath, String fileType){
        this.filePath = filePath;
        this. fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileType() {
        return fileType;
    }
}
