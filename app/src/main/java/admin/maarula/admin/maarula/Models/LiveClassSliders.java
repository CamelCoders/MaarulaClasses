package admin.maarula.admin.maarula.Models;

public class LiveClassSliders {
    private int Image;
    private String Title;
    private boolean isLives;

    public LiveClassSliders(int image, String title, boolean isLive) {
        Image = image;
        Title = title;
        isLives = isLive;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isLive() {
        return isLives;
    }

    public void setLive(boolean live) {
        isLives = live;
    }
}
