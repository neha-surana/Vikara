package api;

import business.ApplicationContext;
import business.survey.Survey;
import business.survey.SurveyDao;
import business.user.User;
import business.user.UserDao;
import business.category.Category;
import business.category.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;


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

//    @GET
//    @Path("categories/{category-id}/user")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<User> booksByCategoryId(@PathParam("category-id") long categoryId,
//                                        @Context HttpServletRequest httpRequest) {
//        try {
//            Category category = categoryDao.findByCategoryId(categoryId);
//            if (category == null) {
//                throw new ApiException(String.format("No such category id: %d", categoryId));
//            }
//            return userDao.findUserByUserId(category.getCategoryId());
//        } catch (Exception e) {
//            throw new ApiException(String.format("Books lookup by category-id %d failed", categoryId), e);
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

//
//    // categories/name/{category-name}/books
//    @GET
//    @Path("categories/name/{category-name}/books")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<User> booksByCategoryName(@PathParam("category-name") String categoryName,
//                                          @Context HttpServletRequest httpRequest) {
//        try {
//            Category category = categoryDao.findByName(categoryName);
//            if (category == null) {
//                throw new ApiException(String.format("No such category with name: "+ categoryName));
//            }
//            return userDao.findUserByUserId(category.getCategoryId());
//        } catch (Exception e) {
//            throw new ApiException(String.format("Books lookup by category-name "+categoryName+ " failed"), e);
//        }
//    }

    @GET
    @Path("user/username/{user-name}/")
    @Produces(MediaType.APPLICATION_JSON)
    public User userByUserName(@PathParam("user-name") String username,
                                          @Context HttpServletRequest httpRequest) {
        try {
            User user = userDao.findUserByUserName(username);
            if (user == null) {
                throw new ApiException(String.format("No such user with username: "+ username));
            }
            return user;
        } catch (Exception e) {
            throw new ApiException(String.format("User lookup by user-name "+username+ " failed"), e);
        }
    }

    /**
     * POST REQUESTS HERE
     * @param categoryName
     * @param httpsRequest
     */

    @POST
    @Path("post/category/{category-name}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void createCategory(@PathParam("category-name") String categoryName, @Context HttpServletRequest httpsRequest){
        try{
            categoryDao.createCategory(categoryName);
        }catch(Exception e){
            throw new ApiException(String.format("Category creation failed", categoryName), e);
        }
    }

    //localhost:8080/Vikara/api/create/user

    @POST
    @Path("create/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(@Context HttpServletRequest httpsRequest, @Context HttpServletResponse httpServletResponse)throws IOException {
        String body=getRequestBody(httpsRequest);

        System.out.println(body);
        Gson g = new Gson();
        User user = g.fromJson(body, User.class);

        System.out.println(user);
        try{
            userDao.createUser(user);
            System.out.println(" after Function call");
        } catch(Exception e){
            throw new ApiException(String.format("User creation failed"), e);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
        httpServletResponse.getWriter().flush();
    }


    @POST
    @Path("create/survey")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSurvey(@Context HttpServletRequest httpsRequest, @Context HttpServletResponse httpServletResponse)throws IOException {
        String body=getRequestBody(httpsRequest);
        Gson g = new Gson();
        System.out.println(body);
        Survey survey = g.fromJson(body, Survey.class);

        System.out.println(survey);
        try{
            surveyDao.createSurvey(survey);
            System.out.println(" after Function call");
        } catch(Exception e){
            throw new ApiException(String.format("Survey creation failed"), e);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
        httpServletResponse.getWriter().flush();
    }


    private String getRequestBody(HttpServletRequest httpsRequest){
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = httpsRequest.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
            bufferedReader.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

        body = stringBuilder.toString();
        return body;
    }
}

