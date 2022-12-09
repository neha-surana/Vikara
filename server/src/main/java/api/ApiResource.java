package api;

import business.ApplicationContext;
import business.blog.Blog;
import business.blog.BlogDao;
import business.category.CategoryDao;
import business.comment.Comment;
import business.comment.CommentDao;
import business.events.Events;
import business.events.GoogleSearch;
import business.events.SerpApiSearchException;
import business.shop.Shop;
import business.shop.ShopDao;
import business.itemCategory.ItemCategory;
import business.itemCategory.ItemCategoryDao;
import business.survey.Survey;
import business.survey.SurveyDao;
import business.user.User;
import business.user.UserDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationPath("/")
@Path("/")
public class ApiResource {

private final ShopDao shopDao = ApplicationContext.INSTANCE.getShopDao();
private final ItemCategoryDao itemCategoryDao = ApplicationContext.INSTANCE.getItemCategoryDao();
private final UserDao userDao = ApplicationContext.INSTANCE.getUserDao();
    private final SurveyDao surveyDao = ApplicationContext.INSTANCE.getSurveyDao();
    private final CategoryDao categoryDao = ApplicationContext.INSTANCE.getCategoryDao();
    private final BlogDao blogDao = ApplicationContext.INSTANCE.getBlogDao();
    private final CommentDao commentDao = ApplicationContext.INSTANCE.getCommentDao();


    @GET
    @Path("categories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemCategory> categories(@Context HttpServletRequest httpRequest) {
        try {
            return itemCategoryDao.findAll();
        } catch (Exception e) {
            throw new ApiException("categories lookup failed", e);
        }
    }

    @GET
    @Path("shop/items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> shopItems(@Context HttpServletRequest httpRequest) {
        try {
            return shopDao.findAll();
        } catch (Exception e) {
            throw new ApiException("categories lookup failed", e);
        }
    }



@GET
@Path("categories/items/{item-category-id}")
@Produces(MediaType.APPLICATION_JSON)
public ItemCategory itemCategoryById(@PathParam("item-category-id") long itemCategory_id,
                             @Context HttpServletRequest httpRequest) {
    try {
        ItemCategory result = itemCategoryDao.findByItemCategoryId(itemCategory_id);
        if (result == null) {
            throw new ApiException(String.format("No such category id: %d", itemCategory_id));
        }
        return result;
    } catch (Exception e) {
        throw new ApiException(String.format("Category lookup by item-category-id %d failed", itemCategory_id), e);
    }
}


@GET
@Path("shop/{item-id}")
@Produces(MediaType.APPLICATION_JSON)
public Shop ItemById(@PathParam("item-id") long item_id,
                     @Context HttpServletRequest httpRequest) {
    try {
        Shop result = shopDao.findByItemId(item_id);
        if (result == null) {
            throw new ApiException(String.format("No such item id: %d", item_id));
        }
        return result;
    } catch (Exception e) {
        throw new ApiException(String.format("Item lookup by item-id %d failed", item_id), e);
    }
}

@GET
@Path("categories/{item-category-id}/items")
@Produces(MediaType.APPLICATION_JSON)
public List<Shop> itemsByCategoryId(@PathParam("item-category-id") long itemCategory_id,
                                    @Context HttpServletRequest httpRequest) {
    try {
        ItemCategory category = itemCategoryDao.findByItemCategoryId(itemCategory_id);
        if (category == null) {
            throw new ApiException(String.format("No such category id: %d", itemCategory_id));
        }
        return shopDao.findByItemCategoryId(category.getItemCategory_id());
    } catch (Exception e) {
        throw new ApiException(String.format("Items lookup by category-id %d failed", itemCategory_id), e);
    }
}

@GET
@Path("categories/{category-id}/suggested-items")
@Produces(MediaType.APPLICATION_JSON)
public List<Shop> suggestedBooks(@PathParam("category-id") long itemCategory_id,
                                 @QueryParam("limit") @DefaultValue("6") int limit,
                                 @Context HttpServletRequest request) {
    try {
        return shopDao.findRandomByItemCategoryId(itemCategory_id, limit);
    } catch (Exception e) {
        throw new ApiException("products lookup via categoryName failed", e);
    }
}

@GET
@Path("categories/name/{category-name}")
@Produces(MediaType.APPLICATION_JSON)
public ItemCategory itemCategoryByName(@PathParam("category-name") String name,
                               @Context HttpServletRequest httpRequest) {
    try {
        ItemCategory result = itemCategoryDao.findByName(name);
        if (result == null) {
            throw new ApiException(String.format("No such category: %s", name));
        }
        return result;
    } catch (Exception e) {
        throw new ApiException(String.format("Category lookup by category-name %s failed", name), e);
    }
}



    @GET
    @Path("categories/name/{category-name}/items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> booksByCategoryName(@PathParam("category-name") String name,
                                          @Context HttpServletRequest httpRequest) {
        try {
            ItemCategory itemCategory = itemCategoryDao.findByName(name);
            if (itemCategory == null) {
                throw new ApiException(String.format("No such category: %s", name));
            }
            return shopDao.findByItemCategoryId(itemCategory.getItemCategory_id());
        } catch (Exception e) {
            throw new ApiException(String.format("Items lookup by category-name %s failed", name), e);
        }
    }

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


    @GET
    @Path("categories/name/{category-name}/suggested-items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> suggestedBooksByCategoryName(@PathParam("category-name") String name,
                                                   @QueryParam("limit") @DefaultValue("6") int limit,
                                                   @Context HttpServletRequest request) {
        try {
            ItemCategory itemCategory = itemCategoryDao.findByName(name);
            if (itemCategory == null) {
                throw new ApiException(String.format("No such category: %s", name));
            }
            return shopDao.findRandomByItemCategoryId(itemCategory.getItemCategory_id(), limit);
        } catch (Exception e) {
            throw new ApiException("products lookup via categoryName failed", e);
        }
    }

    @GET
    @Path("check/user/{user-name}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkUsername(@PathParam("user-name") String username,
                                @Context HttpServletRequest httpRequest) {
        System.out.println("Check user endpoint called");
        try {
            User user = userDao.findUserByUserName(username);
            if (user != null) {
//                throw new ApiException(String.format("User already exists "+ username));
                return "{\"exitsts\":true}";
            }
        } catch (Exception e) {
            throw new ApiException(String.format("User check by user-name "+username+ " failed"), e);
        }
        System.out.println("Check user endpoint call finished");
        return "{\"exitsts\":false}";
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
//        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
//        httpServletResponse.getWriter().flush();
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

    @GET
    @Path("blogs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> blogs(@Context HttpServletRequest httpRequest) {
        try {
            return blogDao.getAllBlogs();
        } catch (Exception e) {
            throw new ApiException("categories lookup failed", e);
        }
    }

    @GET
    @Path("comments/{blog-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> booksByCategoryName(@PathParam("blog-id") Long id,
                                             @Context HttpServletRequest httpRequest) {
//        System.out.println(id);
        try {
            return commentDao.findByCommentId(id);
        } catch (Exception e) {
            throw new ApiException(String.format("Items lookup by blog-id %s failed", id), e);
        }
    }

    @POST
    @Path("create/blog")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBlog(@Context HttpServletRequest httpsRequest, @Context HttpServletResponse httpServletResponse)throws IOException {
        String body=getRequestBody(httpsRequest);

        System.out.println(body);
        Gson g = new Gson();
        Blog blog = g.fromJson(body, Blog.class);

        System.out.println(blog);
        try{
            blogDao.createBlog(blog);
            System.out.println(" after Function call");
        } catch(Exception e){
            throw new ApiException(String.format("BLog creation failed"), e);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
        httpServletResponse.getWriter().flush();
    }

    @POST
    @Path("create/comment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createComment(@Context HttpServletRequest httpsRequest, @Context HttpServletResponse httpServletResponse)throws IOException {
        String body=getRequestBody(httpsRequest);

        System.out.println(body);
        Gson g = new Gson();
        Comment comment = g.fromJson(body, Comment.class);

        System.out.println(comment);
        try{
            commentDao.createComment(comment);
            System.out.println(" after Function call");
        } catch(Exception e){
            throw new ApiException(String.format("Comment creation failed"), e);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
        httpServletResponse.getWriter().flush();
    }

    @POST
    @Path("update/blog/{blog-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createComment(@PathParam("blog-id") Long id,
                              @Context HttpServletRequest httpsRequest,
                              @Context HttpServletResponse httpServletResponse)throws IOException {
        String body=getRequestBody(httpsRequest);
        System.out.println("hey there");
        try{
            blogDao.updateBlogById(id);
            System.out.println(" after Function call");
        } catch(Exception e){
            throw new ApiException(String.format("Update blog failed"), e);
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().write("{\"Hi-there\":\"\"}");
        httpServletResponse.getWriter().flush();
    }

    @GET
    @Path("favourite")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> favouriteblogs(@Context HttpServletRequest httpRequest) {
        try {
            return blogDao.getFavouriteBlogs();
        } catch (Exception e) {
            throw new ApiException("categories lookup failed", e);
        }
    }

    @GET
    @Path("events/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> events(@PathParam("city") String city, @Context HttpServletRequest httpRequest) {
        List<Events> events = new ArrayList<>();
        Map<String, String> parameter = new HashMap<>();
        String title, date, thumbnail;
        String address = "";

        parameter.put("engine", "google_events");
        parameter.put("q", "Events in "+ city);
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        parameter.put("api_key", "e321260d45c8b020867bcce2df2c160ffa68611cb1d60852840bf4e15b5dd6f2");

        GoogleSearch search = new GoogleSearch(parameter);

        try
        {
            JsonObject results = search.getJson();
            JsonArray events_results = results.getAsJsonObject().get("events_results").getAsJsonArray();
            for (int j = 0; j < events_results.size(); j++){
                title = events_results.get(j).getAsJsonObject().get("title").getAsString();
                thumbnail = events_results.get(j).getAsJsonObject().get("thumbnail").getAsString();

                JsonArray location = events_results.get(j).getAsJsonObject().get("address").getAsJsonArray();
                for (int i = 0; i < location.size(); i++){
                    address += location.get(i).getAsString() + " ";
                }

                String format = events_results.get(j).getAsJsonObject().get("date").getAsJsonObject().get("when").getAsString();
                format = format.replaceAll("[^\\p{ASCII}]", "");
                format = format.replace("  ", "-");
                date = events_results.get(j).getAsJsonObject().get("date").getAsJsonObject().get("start_date").getAsString() + " " + format;

                Events event = new Events(title, address, date, thumbnail);
                events.add(event);
            }
            System.out.println(events);
        }
        catch (SerpApiSearchException ex)
        {
            System.out.println("Exception:");
            System.out.println(ex.toString());
        }
        return events;
    }
}
