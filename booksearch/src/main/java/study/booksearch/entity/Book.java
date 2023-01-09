package study.booksearch.entity;

public class Book {
    private String id;
    private String title;
    private String category_id;
    private Status status;
    private String url;
    private String image_url;

    public Book(String id, String title, String category_id, Status status, String url, String image_url) {
        this.id = id;
        this.title = title;
        this.category_id = category_id;
        this.status = status;
        this.url = url;
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
