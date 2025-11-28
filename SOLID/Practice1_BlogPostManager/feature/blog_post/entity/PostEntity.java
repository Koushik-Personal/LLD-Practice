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
}
