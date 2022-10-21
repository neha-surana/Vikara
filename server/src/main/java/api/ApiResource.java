package api;

import business.ApplicationContext;
import business.survey.SurveyDao;
import business.user.User;
import business.user.UserDao;
import business.category.Category;
import business.category.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/")
@Path("/")
public class ApiResource {

    private final UserDao userDao = ApplicationContext.INSTANCE.getBookDao();
    private final CategoryDao categoryDao = ApplicationContext.INSTANCE.getCategoryDao();
    private final SurveyDao surveyDao = ApplicationContext.INSTANCE.getSurveyDao();

    @GET
    @Path("categories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> categories(@Context HttpServletRequest httpRequest) {
        try {
            return categoryDao.findAll();
        } catch (Exception e) {
            throw new ApiException("categories lookup failed", e);
        }
    }

    @GET
    @Path("categories/{category-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category categoryById(@PathParam("category-id") long categoryId,
                                 @Context HttpServletRequest httpRequest) {
        try {
            Category result = categoryDao.findByCategoryId(categoryId);
            if (result == null) {
                throw new ApiException(String.format("No such category id: %d", categoryId));
            }
            return result;
        } catch (Exception e) {
            throw new ApiException(String.format("Category lookup by category-id %d failed", categoryId), e);
        }
    }

    @GET
    @Path("user/{user-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User bookById(@PathParam("user-id") long bookId,
                         @Context HttpServletRequest httpRequest) {
        try {
            User result = userDao.findByUserId(bookId);
            if (result == null) {
                throw new ApiException(String.format("No such book id: %d", bookId));
            }
            return result;
        } catch (Exception e) {
            throw new ApiException(String.format("Book lookup by book-id %d failed", bookId), e);
        }
    }

    @GET
    @Path("categories/{category-id}/user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> booksByCategoryId(@PathParam("category-id") long categoryId,
                                        @Context HttpServletRequest httpRequest) {
        try {
            Category category = categoryDao.findByCategoryId(categoryId);
            if (category == null) {
                throw new ApiException(String.format("No such category id: %d", categoryId));
            }
            return userDao.findUserByCategoryId(category.getCategoryId());
        } catch (Exception e) {
            throw new ApiException(String.format("Books lookup by category-id %d failed", categoryId), e);
        }
    }
//
//    // uncomment
//    @GET
//    @Path("categories/{category-id}/suggested-books")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<User> suggestedBooks(@PathParam("category-id") long categoryId,
//                                     @QueryParam("limit") @DefaultValue("3") int limit,
//                                     @Context HttpServletRequest request) {
//        try {
//            return userDao.findRandomByCategoryId(categoryId, limit);
//        } catch (Exception e) {
//            throw new ApiException("products lookup via categoryName failed", e);
//        }
//    }

    // TODO Implement the following APIs

    // categories/name/{category-name}
    @GET
    @Path("categories/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category requestedCategoryByName(@PathParam("name") String name,
                                     @QueryParam("limit") @DefaultValue("3") int limit,
                                     @Context HttpServletRequest request) {
        try {
            Category category = categoryDao.findByName(name);
            if(category==null)throw new ApiException(String.format("No such category name: "+ name));
            return category;
        } catch (Exception e) {
            throw new ApiException("products lookup via categoryName failed", e);
        }
    }


    // categories/name/{category-name}/books
    @GET
    @Path("categories/name/{category-name}/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> booksByCategoryName(@PathParam("category-name") String categoryName,
                                          @Context HttpServletRequest httpRequest) {
        try {
            Category category = categoryDao.findByName(categoryName);
            if (category == null) {
                throw new ApiException(String.format("No such category with name: "+ categoryName));
            }
            return userDao.findUserByCategoryId(category.getCategoryId());
        } catch (Exception e) {
            throw new ApiException(String.format("Books lookup by category-name "+categoryName+ " failed"), e);
        }
    }

    // categories/name/{category-name}/suggested-books
//    @GET
//    @Path("categories/name/{category-name}/suggested-books")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<User> suggestedBooksbyCategoryName(@PathParam("category-name") String categoryName,
//                                                   @QueryParam("limit") @DefaultValue("3") int limit,
//                                                   @Context HttpServletRequest request) {
//        try {
//            Category category=categoryDao.findByName(categoryName);
//            if(category==null)throw new ApiException(String.format("No such category with name: "+ categoryName));
//            return userDao.findRandomByCategoryId(category.getCategoryId(), limit);
//        } catch (Exception e) {
//            throw new ApiException("products lookup via categoryName failed", e);
//        }
//    }

}
