package admin.maarula.admin.maarula.Models;

public class CourseDetail {
    String name;
    int img_link;

    public CourseDetail(String name, int img_link) {
        this.name = name;
        this.img_link = img_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_link() {
        return img_link;
    }

    public void setImg_link(int img_link) {
        this.img_link = img_link;
    }
}
