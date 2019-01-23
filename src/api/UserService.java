package api;

import server.User;

public interface UserService {
    User getUserInfo(String access, String login);
    boolean refreshUserInfo(User user);
}
