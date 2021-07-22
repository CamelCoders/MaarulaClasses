package admin.maarula.admin.maarula.Models;

public class LiveClassSlider {

    public String name;
    public String video_url;
    public String slide_no;
    public String img_thumb;

    public LiveClassSlider(String name, String video_url, String img_thumb) {
        this.name = name;
        this.video_url = video_url;
        this.slide_no = "";
        this.img_thumb = img_thumb;
    }

    public LiveClassSlider(String name, String video_url) {
        this.name = name;
        this.video_url = video_url;
        this.slide_no = "";
        this.img_thumb = "";
    }
}
