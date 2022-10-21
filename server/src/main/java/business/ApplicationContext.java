
package business;

import business.survey.SurveyDao;
import business.survey.SurveyDaoJdbc;
import business.user.UserDao;
import business.user.UserDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;

public class ApplicationContext {

    // TODO Add field and complete the getter for bookDao

    private CategoryDao categoryDao;
    private UserDao userDao;


    private SurveyDao surveyDao;
    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        userDao =new UserDaoJdbc();
        surveyDao =new SurveyDaoJdbc();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }


    public SurveyDao getSurveyDao() {
        return surveyDao;
    }

    public UserDao getBookDao() { return userDao; }
}
