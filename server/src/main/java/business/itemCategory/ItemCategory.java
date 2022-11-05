
package business.itemCategory;

public class ItemCategory {

    private long itemCategory_id;
    private String name;

    public ItemCategory(long itemCategory_id, String name) {
        this.itemCategory_id = itemCategory_id;
        this.name = name;
    }

    public long getItemCategory_id() {
        return itemCategory_id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "itemCategory_id=" + itemCategory_id +
                ", name='" + name + '\'' +
                '}';
    }
}
