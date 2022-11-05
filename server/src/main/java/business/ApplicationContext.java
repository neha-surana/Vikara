
package business;

import business.book.BookDao;
import business.book.BookDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;
import business.shop.ShopDao;
import business.shop.ShopDaoJdbc;
import business.itemCategory.ItemCategoryDao;
import business.itemCategory.ItemCategoryDaoJdbc;

public class ApplicationContext {

    // TODO Add field and complete the getter for bookDao

    private CategoryDao categoryDao;
    private ItemCategoryDao itemCategoryDao;

    private BookDao bookDao;
    private ShopDao shopDao;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        itemCategoryDao=new ItemCategoryDaoJdbc();
        bookDao = new BookDaoJdbc();
        shopDao=new ShopDaoJdbc();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
    public ItemCategoryDao getItemCategoryDao() {
        return itemCategoryDao;
    }

    public BookDao getBookDao() { return bookDao; }
    public ShopDao getShopDao() { return shopDao; }
}
