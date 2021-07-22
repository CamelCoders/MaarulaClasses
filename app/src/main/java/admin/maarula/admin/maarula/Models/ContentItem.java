package admin.maarula.admin.maarula.Models;

public class ContentItem {
    String titleMain, titleSub;

    public ContentItem(String titleMain, String titleSub) {
        this.titleMain = titleMain;
        this.titleSub = titleSub;
    }

    public String getTitleMain() {
        return titleMain;
    }

    public void setTitleMain(String titleMain) {
        this.titleMain = titleMain;
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }
}
