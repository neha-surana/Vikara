package business.blog;

import business.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.BookstoreDbException.BookstoreQueryDbException;
import business.VikarastoreDbException;

public class BlogDaoJdbc implements BlogDao {

    private static final String GET_ALL_BLOGS_SQL =
            "SELECT * from blogs where share = 'public'";

    private static String CREATE_BLOG_SQL="insert into blogs (title, description, share, upload_image)" +
            "values (?,?,?,?)";

    private static String UPDATE_BLOG_BY_ID_SQL="update blogs set favourite = 1 " +
            "WHERE blog_id = ?";

    private static final String GET_ALL_FAVOURITE_BLOGS_SQL =
            "SELECT * from blogs where share = 'private' or favourite = 1";

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = new ArrayList<>();

        // TODO: Implement this method.
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOGS_SQL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Blog blog = readBlog(resultSet);
                    blogs.add(blog);
                }
            }
        } catch (SQLException e) {
            throw new BookstoreQueryDbException("Encountered a problem finding books from category id: " + e);
        }

        return blogs;
    }

    @Override
    public void createBlog(Blog blog) {
        try(Connection connection =
                    JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_BLOG_SQL)
        ){
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getDescription());
            statement.setString(3,blog.getShare());
            statement.setString(4,blog.getUpload_image());
            statement.execute();
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem adding a user " + blog.getTitle(), e);
        }
    }

    @Override
    public void updateBlogById(long blog_id) {
        try(Connection connection =
                    JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG_BY_ID_SQL)
        ){
            statement.setLong(1, blog_id);
//            System.out.println(statement);
            statement.execute();
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem adding a user " + blog_id, e);
        }
    }

    @Override
    public List<Blog> getFavouriteBlogs() {
        List<Blog> favourites = new ArrayList<>();

        // TODO: Implement this method.
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_FAVOURITE_BLOGS_SQL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Blog blog = readBlog(resultSet);
                    favourites.add(blog);
                }
            }
        } catch (SQLException e) {
            throw new BookstoreQueryDbException("Encountered a problem finding books from category id: " + e);
        }

        return favourites;
    }


    private Blog readBlog(ResultSet resultSet) throws SQLException {
        long blog_id = resultSet.getLong("blog_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String share = resultSet.getString("share");
        String upload_image = resultSet.getString("upload_image");
        boolean favourite = resultSet.getBoolean("favourite");
        return new Blog(blog_id, title, description, share, upload_image, favourite);
    }

}
