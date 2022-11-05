package api;

import business.ApplicationContext;
import business.shop.Shop;
import business.shop.ShopDao;
import business.itemCategory.ItemCategory;
import business.itemCategory.ItemCategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/")
@Path("/")
public class ApiResource {

private final ShopDao shopDao = ApplicationContext.INSTANCE.getShopDao();
private final ItemCategoryDao itemCategoryDao = ApplicationContext.INSTANCE.getItemCategoryDao();


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
}
