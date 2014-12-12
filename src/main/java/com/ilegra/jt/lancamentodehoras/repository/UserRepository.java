package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.Optional;

public interface UserRepository {
    
    public Optional<User> login(String login, String password);
}
