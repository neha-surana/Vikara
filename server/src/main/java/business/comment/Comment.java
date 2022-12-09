package business.comment;

import java.util.Date;

public class Comment {

    private long comment_id;
    private String username;
    private String comment;

    private Date date_created;
    private long blog_id;

//    Getter and Setters
    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(long blog_id) {
        this.blog_id = blog_id;
    }

    public Comment(long comment_id, String username, String comment, Date date_created, long blog_id) {
        this.comment_id = comment_id;
        this.username = username;
        this.comment = comment;
        this.date_created = date_created;
        this.blog_id = blog_id;
      }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", date_created=" + date_created +
                ", blog_id=" + blog_id +
                '}';
    }

}
