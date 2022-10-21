package business.survey;

import business.JdbcUtils;
import business.VikaraDbSetupException.VikaraQueryDbSetupException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyDaoJdbc implements SurveyDao {

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

    @Override
    public List<Survey> findAll() {
        List<Survey> categories = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Survey category = readCategory(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new VikaraQueryDbSetupException("Encountered a problem finding all categories", e);
        }
        return categories;
    }

    @Override
    public Survey findBySurveyId(long categoryId) {
        Survey category = null;
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
    public Survey findBySurveyName(String name) {
        Survey category = null;
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

    private Survey readCategory(ResultSet resultSet) throws SQLException {
        long categoryId = resultSet.getLong("category_id");
        String name = resultSet.getString("name");
        return new Survey(categoryId, name);
    }

}
