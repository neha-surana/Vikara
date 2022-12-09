package business.user;

import business.VikarastoreDbException;
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

    private static String FIND_USER_BY_USER_ID_SQL =
            "SELECT book_id, title, author, description, price, rating, is_public, is_featured, category_id from user where category_id=?";

    private static String FIND_USER_BY_USER_NAME_SQL =
            "SELECT * from user where username=?";

    private static String CREATE_USER_SQL="insert into user (username, email, password, confirm_password, address,\n" +
            "                  country, state, zipcode)" +
            "values (?,?,?,?,?,?,?,?)";

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
            throw new VikarastoreDbException("Encountered a problem finding book " + userId, e);
        }
        return user;
    }

    @Override
    public User findUserByUserId(long userId) {
        User user=new User();
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_USER_ID_SQL)
                ){
            statement.setLong(1,userId);
            ResultSet resultSet=statement.executeQuery();
            user = readUser(resultSet);
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem finding book with category_id: " + userId, e);
        }

        return user;
    }

    @Override
    public User findUserByUserName(String userName) {
        User user;
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_USER_NAME_SQL)
        ){
            statement.setString(1,userName);
            System.out.println(statement.toString());
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()) user = readUser(resultSet);
            else user=null;
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem finding user with username: " + userName, e);
        }
        return user;
    }


    /**
     * POST Request execution here
     *
     * @return
     * @throws SQLException
     */
    @Override
    public void createUser(User user){
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)
        ){
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getConfirm_password());
            statement.setString(5, user.getAddress());
            statement.setString(6,user.getCountry());
            statement.setString(7,user.getState());
            statement.setString(8,user.getZipcode());
            statement.execute();
        }
        catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem adding a user " + user.getUsername(), e);
        }
    }


    private User readUser(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong("user_id");
        String username = resultSet.getString("username");
        String email=resultSet.getString("email");
        String password = resultSet.getString("password");
        String confirm_password=resultSet.getString("confirm_password");
        String address= resultSet.getString("address");
        String country = resultSet.getString("country");
        String state = resultSet.getString("state");
        String zipcode = resultSet.getString("zipcode");
        return new User(userId, username, email, password, confirm_password, address, country, state, zipcode);
    }
}
