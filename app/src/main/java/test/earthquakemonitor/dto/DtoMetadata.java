package test.earthquakemonitor.dto;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class DtoMetadata {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private long generated;
    private String url;
    private String title;
    private int status;
    private String api;
    private int count;
    // ===========================================================
    // Constructors
    // ===========================================================

    public DtoMetadata() {
    }

    public DtoMetadata(long generated, String url, String title, int status, String api, int count) {
        this.generated = generated;
        this.url = url;
        this.title = title;
        this.status = status;
        this.api = api;
        this.count = count;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public long getGenerated() {
        return generated;
    }

    public void setGenerated(long generated) {
        this.generated = generated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public String toString() {
        return "- metadata: {\n" +
                "generated: " + generated + ",\n" +
                "url: " + url + ",\n" +
                "title: " + title + ",\n" +
                "api: " + api + ",\n" +
                "count: " + count + "\n" +
                "},";
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
