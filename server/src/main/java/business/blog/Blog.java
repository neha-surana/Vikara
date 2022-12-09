package business.blog;

public class Blog {


    private long blog_id;
    private String title;
    private String description;
    private String upload_image;
    private String share;
    private boolean favourite;

    public Blog(long blog_id, String title, String description, String share, String upload_image, boolean favourite) {
        this.blog_id = blog_id;
        this.title = title;
        this.description = description;
        this.share = share;
        this.upload_image = upload_image;
        this.favourite = favourite;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(long blog_id) {
        this.blog_id = blog_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getUpload_image() {
        return upload_image;
    }

    public void setUpload_image(String upload_image) {
        this.upload_image = upload_image;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blog_id=" + blog_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", share=" + share +
                ", upload_image='" + upload_image + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}
