package business.comment;

import business.blog.Blog;
import business.shop.Shop;

import java.util.List;

public interface CommentDao {

    public List<Comment> findByCommentId( long blog_id	);

    public void createComment(Comment comment);
}
