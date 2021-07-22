package admin.maarula.admin.maarula.Models;

public class TestContainer {

    String testMainTitle;
    boolean isAttempted;

    public TestContainer(String testMainTitle, boolean isAttempted) {
        this.testMainTitle = testMainTitle;
        this.isAttempted = isAttempted;
    }

    public boolean isAttempted() {
        return isAttempted;
    }

    public void setAttempted(boolean attempted) {
        isAttempted = attempted;
    }

    public String getTestMainTitle() {
        return testMainTitle;
    }

    public void setTestMainTitle(String testMainTitle) {
        this.testMainTitle = testMainTitle;
    }
}
