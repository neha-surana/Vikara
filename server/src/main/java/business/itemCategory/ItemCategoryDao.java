package business.itemCategory;

import java.util.List;

public interface ItemCategoryDao {

    public List<ItemCategory> findAll();

    public ItemCategory findByItemCategoryId(long itemCategory_id);
//
    public ItemCategory findByName(String name);
}
