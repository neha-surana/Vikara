package business.shop;

import java.util.List;

public interface ShopDao {

    public Shop findByItemId(long item_id);

    public List<Shop> findByItemCategoryId(long itemCategory_id	);

    public List<Shop> findRandomByItemCategoryId(long itemCategory_id, int limit);

}
