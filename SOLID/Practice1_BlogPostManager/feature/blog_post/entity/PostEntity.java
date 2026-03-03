package feature.blog_post.entity;
public class PostEntity {
    private int id;
    private int userId;
    private String title;
    private String content;
    private String date;


    public PostEntity(int id, int userId, String title, String content, String date) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
