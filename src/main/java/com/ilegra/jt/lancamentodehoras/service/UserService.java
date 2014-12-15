package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.Optional;

public class UserService {

    public Optional<User> authenticateUser(String login, String password) {
        UserDAO dao = new UserDAO();
        Optional<User> userLogin = dao.login(login, password);
        return userLogin;
    }
}
