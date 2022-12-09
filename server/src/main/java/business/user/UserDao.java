package business.user;

import java.util.List;

public interface UserDao {

    public User findByUserId(long bookId);

    public void createUser(User user);

    public User findUserByUserName(String userName);

    public User findUserByUserId(long userId);
}
