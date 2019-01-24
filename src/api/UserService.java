package api;

import server.User;

public interface UserService {
    User getUserInfo(boolean access, String login);
    boolean refreshUserInfo(User user);
}
