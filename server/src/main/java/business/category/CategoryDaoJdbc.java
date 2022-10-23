package business.category;

import business.VikaraDbSetupException.VikaraQueryDbSetupException;
import business.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoJdbc implements CategoryDao {

    private static final String FIND_ALL_SQL =
            "SELECT category_id, name " +
                    "FROM category";

    private static final String FIND_BY_CATEGORY_ID_SQL =
            "SELECT category_id, name " +
                    "FROM category " +
                    "WHERE category_id = ?";

    private static final String FIND_BY_NAME_SQL =
            "SELECT category_id, name " +
                    "FROM category " +
                    "WHERE name = ?";

    private static final String CREATE_CATEGORY="INSERT into category (name) values (?);";

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Category category = readCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding all categories", e);
        }
        return categories;
    }

    @Override
    public Category findByCategoryId(long categoryId) {
        Category category = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_CATEGORY_ID_SQL)) {
            statement.setLong(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    category = readCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding category " + categoryId, e);
        }
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME_SQL)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    category = readCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding category with name" + name, e);
        }
        return category;
    }

    @Override
    public void createCategory(String category){
//        System.out.println("  Function Called  ");
        try(Connection connection = JdbcUtils.getConnection();
        PreparedStatement statement=connection.prepareStatement(CREATE_CATEGORY)){
//            System.out.println("  Inside Try ");
            statement.setString(1,category);
//            System.out.println("\n\n-----------------------Query--------------"+"\n"+statement.toString()+"\n"+"-------------------\n");
            statement.execute();
//            System.out.println("  After Query ");
        }catch(Exception e){
            throw new VikaraQueryDbSetupException("Encountered a problem creating a category " + category, e);
        }
    }

    private Category readCategory(ResultSet resultSet) throws SQLException {
        long categoryId = resultSet.getLong("category_id");
        String name = resultSet.getString("name");
        return new Category(categoryId, name);
    }

}
