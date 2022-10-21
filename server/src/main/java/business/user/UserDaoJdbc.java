package business.user;

import business.VikaraDbSetupException.VikaraQueryDbSetupException;
import business.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private static final String FIND_BY_USER_ID_SQL =
            "SELECT book_id, title, author, description, price, rating, is_public, is_featured, category_id " +
                    "FROM book " +
                    "WHERE book_id = ?";

    private static String FIND_USER_BY_CATEGORY_ID_SQL =
            "SELECT book_id, title, author, description, price, rating, is_public, is_featured, category_id from user where category_id=?";


//    private static final String FIND_RANDOM_BY_CATEGORY_ID_SQL =
//            "SELECT book_id, title, author, description, price, rating, is_public, is_featured, category_id " +
//                    "FROM book " +
//                    "WHERE category_id = ? " +
//                    "ORDER BY RAND() " +
//                    "LIMIT ?";

    @Override
    public User findByUserId(long userId) {
        User user = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_USER_ID_SQL)) {
            statement.setLong(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = readUser(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding book " + userId, e);
        }
        return user;
    }

    @Override
    public List<User> findUserByCategoryId(long categoryId) {
        List<User> users = new ArrayList<>();
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_CATEGORY_ID_SQL)
                ){
            statement.setLong(1,categoryId);
            try(ResultSet resultSet=statement.executeQuery()){
                while(resultSet.next()){
                    User user =readUser(resultSet);
                    users.add(user);
                }
            }
        }
        catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding book with category_id: " + categoryId, e);
        }

        return users;
    }
//
//    @Override
//    public List<User> findRandomByCategoryId(long categoryId, int limit) {
//        List<User> users = new ArrayList<>();
//
//        try(Connection connection = JdbcUtils.getConnection();
//            PreparedStatement statement = connection.prepareStatement(FIND_RANDOM_BY_CATEGORY_ID_SQL)
//        ){
//            statement.setLong(1,categoryId);
//            statement.setInt(2,limit);
//            try(ResultSet resultSet=statement.executeQuery()){
//                while(resultSet.next()){
//                    User user =readBook(resultSet);
//                    users.add(user);
//                }
//            }
//        }
//        catch (SQLException e) {
//            throw new VikaraQueryDbSetupException("Encountered a problem finding book with category_id: " + categoryId, e);
//        }
//
//        return users;
//    }


    private User readUser(ResultSet resultSet) throws SQLException {
        long bookId = resultSet.getLong("book_id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String description=resultSet.getString("description");
        int price = resultSet.getInt("price");
        int rating= resultSet.getInt("rating");
        boolean isPublic = resultSet.getBoolean("is_public");
        boolean isFeatured= resultSet.getBoolean("is_featured");
        long categoryId = resultSet.getLong("category_id");
        return new User(bookId, title, author, description, price, rating, isPublic,isFeatured, categoryId);
    }
}
