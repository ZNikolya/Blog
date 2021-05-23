package homework.blog.model;


import java.util.Date;
import java.util.Objects;

public class Post {

    private String title;
    private String text;
    private Category category;
    private Date createdDate;

    public Post(String title, String text, Category category, Date createdDate) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.createdDate = createdDate;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(text, post.text) && category == post.category && Objects.equals(createdDate, post.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, category, createdDate);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", createdDate=" + createdDate +
                '}';
    }
}