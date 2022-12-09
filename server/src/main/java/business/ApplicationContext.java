
package business;

import business.blog.BlogDao;
import business.blog.BlogDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;
import business.comment.CommentDao;
import business.comment.CommentDaoJdbc;
import business.shop.ShopDao;
import business.shop.ShopDaoJdbc;
import business.itemCategory.ItemCategoryDao;
import business.itemCategory.ItemCategoryDaoJdbc;
import business.survey.SurveyDao;
import business.survey.SurveyDaoJdbc;
import business.user.UserDao;
import business.user.UserDaoJdbc;

public class ApplicationContext {

    // TODO Add field and complete the getter for bookDao

    private CategoryDao categoryDao;
    private ItemCategoryDao itemCategoryDao;
    private UserDao userDao;
    private SurveyDao surveyDao;

    private ShopDao shopDao;

    private BlogDao blogDao;

    private CommentDao commentDao;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        itemCategoryDao=new ItemCategoryDaoJdbc();
        shopDao=new ShopDaoJdbc();
        userDao=new UserDaoJdbc();
        surveyDao=new SurveyDaoJdbc();
        blogDao=new BlogDaoJdbc();
        commentDao = new CommentDaoJdbc();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
    public ItemCategoryDao getItemCategoryDao() {
        return itemCategoryDao;
    }

    public ShopDao getShopDao() { return shopDao; }
    public UserDao getUserDao() { return userDao; }
    public SurveyDao getSurveyDao() { return surveyDao; }
    public BlogDao getBlogDao() { return blogDao; }

    public CommentDao getCommentDao() { return commentDao; }
}
