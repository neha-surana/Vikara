package business.itemCategory;

import business.VikarastoreDbException;
import business.VikarastoreDbException.VikarastoreQueryDbException;
import business.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoryDaoJdbc implements ItemCategoryDao {

    private static final String FIND_ALL_SQL =
            "SELECT itemCategory_id, name " +
                    "FROM itemcategory";

    private static final String FIND_BY_ITEMCATEGORY_ID_SQL =
            "SELECT itemCategory_id, name " +
                    "FROM itemcategory " +
                    "WHERE itemCategory_id = ?";

    private static final String FIND_BY_NAME_SQL =
            "SELECT itemCategory_id, name " +
                    "FROM itemcategory " +
                    "WHERE name = ?";

    @Override
    public List<ItemCategory> findAll() {
        List<ItemCategory> categories = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemCategory itemCategory = readItemCategory(resultSet);
                categories.add(itemCategory);
            }
        } catch (SQLException e) {
            throw new VikarastoreQueryDbException("Encountered a problem finding all categories", e);
        }
        return categories;
    }

    @Override
    public ItemCategory findByItemCategoryId(long itemCategory_id) {
        ItemCategory itemCategory = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ITEMCATEGORY_ID_SQL)) {
            statement.setLong(1, itemCategory_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    itemCategory = readItemCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem finding category " + itemCategory_id, e);
        }
        return itemCategory;
    }
//
    @Override
    public ItemCategory findByName(String name) {
        ItemCategory itemCategory = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME_SQL)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    itemCategory = readItemCategory(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreQueryDbException("Encountered a problem finding category " + name, e);
        }

        // TODO: Finish implementing this method

        return itemCategory;
    }

    private ItemCategory readItemCategory(ResultSet resultSet) throws SQLException {
        long itemCategory_id = resultSet.getLong("itemCategory_id");
        String name = resultSet.getString("name");
        return new ItemCategory(itemCategory_id, name);
    }

}
