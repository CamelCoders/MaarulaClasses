package admin.maarula.admin.maarula.Models;

public class TestContainerChild {
    String testTitle, testDuration;
    boolean fromAttempted;

    public TestContainerChild(String testTitle, String testDuration, boolean fromAttempted) {
        this.testTitle = testTitle;
        this.testDuration = testDuration;
        this.fromAttempted = fromAttempted;
    }

    public boolean isFromAttempted() {
        return fromAttempted;
    }

    public void setFromAttempted(boolean fromAttempted) {
        this.fromAttempted = fromAttempted;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(String testDuration) {
        this.testDuration = testDuration;
    }
}
