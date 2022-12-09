package business.comment;

import business.JdbcUtils;
import business.VikarastoreDbException;
import business.comment.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoJdbc implements CommentDao{

    private static final String FIND_BY_COMMENT_ID_SQL = "SELECT * " +
            "FROM comment " +
            "WHERE blog_id = ?";

    private static String CREATE_COMMENT_SQL="insert into comment (username, comment, blog_id)" +
            "values (?,?,?)";

    @Override
    public List<Comment> findByCommentId(long blog_id) {
        List<Comment> comments = new ArrayList<>();
//        System.out.println(blog_id);

        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_COMMENT_ID_SQL)) {
            statement.setLong(1,blog_id );
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Comment comment = readComment(resultSet);
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreDbException.VikarastoreQueryDbException("Encountered a problem finding comments from blog id: " + blog_id, e);
        }

        return comments;
    }

    @Override
    public void createComment(Comment comment) {
        System.out.println("hi");
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_COMMENT_SQL)
        ){
            statement.setString(1,comment.getUsername());
            statement.setString(2,comment.getComment());
            statement.setLong(3,comment.getBlog_id());
            statement.execute();
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem adding a user " + comment.getComment(), e);
        }
    }

    private Comment readComment(ResultSet resultSet) throws SQLException {
        long comment_id = resultSet.getLong("comment_id");
        String username = resultSet.getString("username");
        String comment = resultSet.getString("comment");
        Date date_created = resultSet.getDate("date_created");
        long blog_id = resultSet.getLong("blog_id");
        return new Comment(comment_id, username, comment, date_created, blog_id);
    }
}
