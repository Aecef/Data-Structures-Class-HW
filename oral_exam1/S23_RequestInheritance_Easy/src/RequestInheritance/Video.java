package RequestInheritance;

public class Video {
    private String url, videoTitle, name;
    Video(String url,String videoTitle,String name){
        this.url = url;
        this.videoTitle = videoTitle;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getVideoTitle() {
        return videoTitle;
    }
}
