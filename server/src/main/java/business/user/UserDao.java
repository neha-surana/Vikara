package business.user;

import java.util.List;

public interface UserDao {

    public User findByUserId(long bookId);

    public List<User> findUserByCategoryId(long categoryId);

//    public List<User> findRandomByCategoryId(long categoryId, int limit);
}
