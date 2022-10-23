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

    private static String CREATE_USER_SQL="insert into user (username, password, confirm_password, first_name, middle_name, last_name, address1, address2,\n" +
            "                  city, state, zipcode,category_id)\n" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?)";


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


    /**
     * POST Request execution here
     *
     * @return
     * @throws SQLException
     */

    public void createUser(User user){
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)
        ){
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getConfirmPassword());
            statement.setString(4,user.getFirstName());
            statement.setString(5,user.getMiddleName());
            statement.setString(6,user.getLastName());
            statement.setString(7, user.getAddress1());
            statement.setString(8,user.getAddress2());
            statement.setString(9,user.getCity());
            statement.setString(10,user.getState());
            statement.setString(11,user.getZipcode());
            statement.setLong(12,user.getCategory_id());
            statement.execute();
        }
        catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem adding a user " + user.getFirstName(), e);
        }
    }


    private User readUser(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong("user_id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String confirm_password=resultSet.getString("confirm_password");
        String first_name = resultSet.getString("first_name");
        String middle_name= resultSet.getString("middle_name");
        String last_name = resultSet.getString("last_name");
        String address1= resultSet.getString("address1");
        String address2 = resultSet.getString("address2");
        String city = resultSet.getString("city");
        String state = resultSet.getString("state");
        String zipcode = resultSet.getString("zipcode");
        long category_id=resultSet.getInt("category_id");
        return new User(userId, username, password, confirm_password, first_name, middle_name, last_name,address1, address2,city,state,zipcode,category_id);
    }
}
