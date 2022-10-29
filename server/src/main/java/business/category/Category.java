
package business.category;

public class Category {

    private long category_id;
    private String name;

    public Category(long category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public long getCategoryId() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + category_id +
                ", name='" + name + '\'' +
                '}';
    }
}
