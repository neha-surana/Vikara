package business.shop;

import business.VikarastoreDbException.VikarastoreQueryDbException;
import business.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoJdbc implements ShopDao {

    private static final String FIND_BY_ITEM_ID_SQL =
            "SELECT item_id, product_name, description, price, rating, is_public, is_featured, itemCategory_id " +
                    "FROM shop " +
                    "WHERE item_id = ?";

    private static final String FIND_BY_ITEM_CATEGORY_ID_SQL = "SELECT item_id, product_name, description, price, rating, is_public, is_featured, itemCategory_id " +
            "FROM shop " +
            "WHERE itemCategory_id = ?";
    // TODO Implement this constant to be used in the findByItemCategoryId method

    private static final String FIND_RANDOM_BY_itemCATEGORY_ID_SQL =
            "SELECT item_id, product_name, description, price, rating, is_public, is_featured, itemCategory_id " +
                    "FROM shop " +
                    "WHERE itemCategory_id = ? " +
                    "ORDER BY RAND() " +
                    "LIMIT ?";

    @Override
    public Shop findByItemId(long item_id) {
        Shop shop = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ITEM_ID_SQL)) {
            statement.setLong(1, item_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    shop = readShop(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreQueryDbException("Encountered a problem finding item " + item_id, e);
        }
        return shop;
    }

    @Override
    public List<Shop> findByItemCategoryId(long itemCategory_id) {
        List<Shop> shops = new ArrayList<>();

        // TODO: Implement this method.
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ITEM_CATEGORY_ID_SQL)) {
            statement.setLong(1,itemCategory_id );
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Shop shop = readShop(resultSet);
                    shops.add(shop);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreQueryDbException("Encountered a problem finding books from category id: " + itemCategory_id, e);
        }

        return shops;
    }

    @Override
    public List<Shop> findRandomByItemCategoryId(long itemCategory_id, int limit) {
        List<Shop> shops = new ArrayList<>();

        // TODO Implement this method
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_RANDOM_BY_itemCATEGORY_ID_SQL)) {
            statement.setLong(1, itemCategory_id);
            statement.setInt(2, limit);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Shop shop = readShop(resultSet);
                    shops.add(shop);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreQueryDbException("Encountered a problem suggesting items from category id: " + itemCategory_id, e);
        }

        return shops;
    }


    private Shop readShop(ResultSet resultSet) throws SQLException {
        long item_id = resultSet.getLong("item_id");
        String product_name = resultSet.getString("product_name");
        int price = resultSet.getInt("price");
        boolean is_public = resultSet.getBoolean("is_public");
        long itemCategory_id = resultSet.getLong("itemCategory_id");
        String description = resultSet.getString("description");
        int rating = resultSet.getInt("rating");
        boolean is_featured = resultSet.getBoolean("is_featured");
        return new Shop(item_id, product_name, description, price, rating, is_public, is_featured, itemCategory_id);
    }
}
