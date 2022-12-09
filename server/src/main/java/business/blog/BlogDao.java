package business.blog;

import business.user.User;

import java.util.List;

public interface BlogDao {

    public List<Blog> getAllBlogs();

    public void createBlog(Blog blog);

    public void updateBlogById(long blog_id);

    public List<Blog> getFavouriteBlogs();
}
