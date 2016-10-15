package lnmiit.android.app.model;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class CouncilFestDetail {
    private String title;
    private String description;

    public CouncilFestDetail(String title1, String description1)
    {
        title = title1;
        description = description1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
